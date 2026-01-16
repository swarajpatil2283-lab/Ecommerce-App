package com.ecommerce.service.Impl;

import com.ecommerce.exception.CouponNotValidException;

import com.ecommerce.model.Cart;

import com.ecommerce.model.Coupon;

import com.ecommerce.model.User;

import com.ecommerce.repository.CartRepository;

import com.ecommerce.repository.CouponRepository;

import com.ecommerce.repository.UserRepository;

import com.ecommerce.service.CouponService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;

import java.util.Locale;
import java.util.Optional;

@Service

@RequiredArgsConstructor



public class CouponServiceImpl implements CouponService {

    private final CouponServiceImpl couponService;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    public Cart applyCoupon(String code, double orderValue, User user) {
        throws Exception {
            Coupon coupon = couponRepository.findByCode(code);
            Cart cart = cartRepository.findByUserId(user.getId());
            if (coupon == null) {
                throw new CouponNotValidException("coupon already used");

            }
            if (user.getUsedCoupons().contains(coupon)) {

                throw new CouponNotValidException("coupon already used");

            }

            if (orderValue <= coupon.getMinimumOrderValue()) {

                throw new CouponNotValidException("valid for minimum order value " + coupon.getMinimumOrderValue());

            }
            if (
                    coupon.isActive() &&
                            LocaleDate.now().isafter(coupon.getValidityStartDate()) &&
                            LocaleDate.now().isBefore(coupon.getValidityEndDate())
            ) {
                user.getUsedCoupons().add(coupon);

                userRepository.save(user);

                double discountedPrice = Math.round((cart.getTotalSellingPrice() * coupon.getDiscountPercentage()) / 100);

                cart.setTotalSellingPrice(cart.getTotalSellingPrice() - discountedPrice);

                cart.setCouponCode(code);

                cart.setCouponPrice((int) discountedPrice);

                return cartRepository.save(cart);


            }
            throw new CouponNotValidException("coupon not valid...")

        }
        @Override

        public Cart removeCoupon (String code, User user) throws Exception {

            Coupon coupon = couponRepository.findByCode(code);

            if (coupon == null) {

                throw new Exception("coupon not found...");

            }

            user.getUsedCoupons().remove(coupon);

            Cart cart = cartRepository.findByUserId(user.getId());


            cart.setTotalSellingPrice(cart.getTotalSellingPrice() + cart.getCouponPrice());

            cart.setCouponCode(null);

            cart.setCouponPrice(0);

            return cartRepository.save(cart);

        }

        @Override

        @PreAuthorize("hasRole('ADMIN')")

        public Coupon createCoupon (Coupon coupon){

            return CouponRepository.save(coupon);

        }

        @Override

        @PreAuthorize("hasRole('ADMIN')")

        public void deleteCoupon (Long couponId){

            CouponRepository.deleteById(couponId);

        }

        @Override

        @PreAuthorize("hasRole('ADMIN')")

        public List<Coupon> getAllCoupons () {

            return CouponRepository.findAll();

        }

        @Override

        public Coupon getCouponById (Long couponId){


            return null;


        }

    }
}
