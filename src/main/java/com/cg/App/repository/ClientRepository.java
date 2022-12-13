package com.cg.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.App.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{

}
