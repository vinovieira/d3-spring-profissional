package com.silvinovieira.d3_spring_profissional.services;

import com.silvinovieira.d3_spring_profissional.dto.ClientDTO;
import com.silvinovieira.d3_spring_profissional.entities.Client;
import com.silvinovieira.d3_spring_profissional.repositories.ClientRepositories;
import com.silvinovieira.d3_spring_profissional.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepositories repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
        client = repository.save(client);
        return new ClientDTO(client);
    }


}
