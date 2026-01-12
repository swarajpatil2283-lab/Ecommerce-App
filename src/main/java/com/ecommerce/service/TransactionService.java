package com.ecommerce.service;
import com.ecommerce.model.Order;
import com.ecommerce.model.Seller;
import com.ecommerce.model.Transaction;
import com.ecommerce.model.User;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySeller(Seller seller);
    List<Transaction>getAllTransactions();
}
