package com.silvinovieira.d3_spring_profissional.services;

import com.silvinovieira.d3_spring_profissional.dto.ClientDTO;
import com.silvinovieira.d3_spring_profissional.entities.Client;
import com.silvinovieira.d3_spring_profissional.repositories.ClientRepositories;
import com.silvinovieira.d3_spring_profissional.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    ClientRepositories repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("recurso não encontrado"));
        return new ClientDTO(client);
    }
}
