package com.ecommerce.response;

import com.ecommerce.dto.OrderHistory;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionResponse {
    private String functionName;

    private Cart userCart;

    private OrderHistory orderHistory;

    private Product product;
}
