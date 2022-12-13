package com.cg.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.App.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
