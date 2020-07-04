package com.demo.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.application.entity.CompositePrimaryKey;
import com.demo.application.entity.ShoppingCarts;

@Repository
public interface ProcessCartRepository extends JpaRepository<ShoppingCarts, CompositePrimaryKey> {
}
