package com.ecommerce.repository;

import java.util.List;

import com.ecommerce.model.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {


}
