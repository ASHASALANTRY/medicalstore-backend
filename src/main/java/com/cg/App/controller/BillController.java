package com.cg.App.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.App.model.Bill;
import com.cg.App.model.Product;
import com.cg.App.service.BillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController//combinatin of @Controller and @ResponseBody
//contoller return  view and restcontroller return response body
@RequestMapping(value="/bill")
public class BillController {
	 private static final Logger logger = LoggerFactory.getLogger(BillController.class);
	    @Autowired
	    BillService billService;
	    
	    
	    @PostMapping("/add")
	    public Bill addBill(@RequestBody Bill bill) {
	    	logger.info("Add Product");
	    	return billService.addBill(bill);
	    }
	    
	    @GetMapping("/getallbills")
	    public Page <Bill>getAllBill(@RequestParam int pageSize, @RequestParam(required = false , defaultValue = "0") int pageNumber){
	    	return billService.getallBills(pageNumber,pageSize);
	    }
	
}
