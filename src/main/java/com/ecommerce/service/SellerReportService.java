package com.ecommerce.service;
import com.ecommerce.model.Seller;
import com.ecommerce.model.SellerReport;
import java.util.List;
import java.util.Optional;


public  interface SellerReportService {
    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);

}
