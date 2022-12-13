package com.cg.App.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cg.App.model.Bill;
import com.cg.App.repository.BillRepository;


@Service
public class BillService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	BillRepository billRepository;
	
	public Bill addBill(Bill bill) {
		LOG.info("Adding bil to databse....");
		return billRepository.save(bill);
	}

	public Page<Bill> getallBills(int pageNumber, int pageSize) {
		LOG.info("fetching all bill records.....");
		return null;
	}
	

}
