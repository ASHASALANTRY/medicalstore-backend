package com.cg.App.service;

import java.util.List;
import java.util.Optional;

import com.cg.App.model.Client;

public interface ClientService {
	List<Client> getAllClient();

	Client createClient(Client client);

	Long removeClient(Long id);
 Optional<Client> findwithId(Long id);
}
