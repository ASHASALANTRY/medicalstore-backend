package com.cg.App.service;


import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.App.exception.MyOrderException;
import com.cg.App.model.Order;
import com.cg.App.repository.OrderRepository;



@Service//it specify that class is service provider
public class OrderService implements IOrderService {
 
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);


    @Autowired
    private OrderRepository orderRepository;


	@Override
	public Order addOrder(Order order) throws MyOrderException {
		logger.info("Add order in service layer "+ order);
        return orderRepository.save(order);
	}

	//get all order data from service layer
    @Override
    public List<Order> getOrderList() throws MyOrderException {
        logger.info("Fetch all admin in service layer ");
        return orderRepository.findAll();
    }
 
    //get single order object from service layer
    @Override
    public Optional<Order> getOrderById(Long orderId) throws MyOrderException {
        logger.info("Trying to fetch admin in service layer ");
        return orderRepository.findById(orderId);
    }
 
    //delete order object from service layer
    @Override
    public void deleteOrder(Long orderId) throws MyOrderException {
        logger.info("Delete Order in service layer ");
        orderRepository.deleteById(orderId);
    }
    
  


}