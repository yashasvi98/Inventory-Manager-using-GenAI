package com.example.inventory.repository;

import com.example.inventory.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {}
