package com.cg.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.App.model.Client;
import com.cg.App.model.Product;
import com.cg.App.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	private ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Client> getAllClient() {
		
		return clientRepository.findAll();
	}

	@Override
	public Client createClient(Client client) {
		
		return clientRepository.save(client);
	}
	public Optional<Client> findwithId(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Long removeClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
		return id;
	}

}
