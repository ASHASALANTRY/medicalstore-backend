package com.cg.App.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.App.exception.ClientNotFoundException;
import com.cg.App.exception.ResourceNotFoundException;
import com.cg.App.model.Admin;
import com.cg.App.model.Client;
import com.cg.App.model.Product;
import com.cg.App.service.ClientService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientController {
	
	 private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	//handler method to handle list of clients and return mode and view
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> listClient() throws ClientNotFoundException {
		try {
		logger.info("Trying to fetch Ward Report list ");
		
		List<Client> client =clientService.getAllClient();
		if(client.isEmpty()) {
			return new ResponseEntity<>(client,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(client,HttpStatus.OK);
	}catch(Exception e) {
		logger.error("Record not found ");
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	//create client rest Api
	@PostMapping("/addClient")
	public Client createClient(@RequestBody Client client){
		
		logger.info("Trying to add Record  : " + client);
		 return  clientService.createClient(client);
		
        
	}
	
	// delete client 
	@DeleteMapping("/deleteClient/{id}")
	public ResponseEntity<String> deleteClient (@PathVariable Long id) throws ClientNotFoundException{
		try {
			clientService.removeClient(id);
		 logger.info("Record Deleted with Id : " +id);
		 Optional<Client> client=clientService.findwithId(id);
		return new ResponseEntity<>("Record deleted with ID"+id,HttpStatus.OK);
		}catch(Exception e){
			logger.error("Record NOT Deleted with Id : " + id);
            return new ResponseEntity<>("Record not found with id : "+id,HttpStatus.EXPECTATION_FAILED);
        
			
		}
	}
	
	//get client by id 
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) throws ClientNotFoundException{
		Optional<Client> admin = null;
		logger.info("Trying to search Record with Id : " + id);
		try {
		Client client = clientService.findwithId(id)
				.orElseThrow(()->new ResourceNotFoundException("client not found with id :"+id));
		return ResponseEntity.ok(client);
		}catch(Exception e) {
			  return new ResponseEntity<Client>(new Client(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	//updating Data
	@PutMapping("/updateClient/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id,@RequestBody Client newClient) throws ClientNotFoundException{
		logger.info("Trying to add Record  : " + newClient);
		try {
		Client currentClient = clientService.findwithId(id)
				.orElseThrow(()->new ResourceNotFoundException("client not found with id :"+id));
		newClient.setClientId(currentClient.getClientId());
	
		Client updatedClient = clientService.createClient(newClient);
		return ResponseEntity.ok(updatedClient);
		}catch(Exception e) {
			 return new ResponseEntity<>(newClient, HttpStatus.EXPECTATION_FAILED); 
		}
		
	}

}
