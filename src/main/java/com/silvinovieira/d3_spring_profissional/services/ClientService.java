package com.silvinovieira.d3_spring_profissional.services;

import com.silvinovieira.d3_spring_profissional.dto.ClientDTO;
import com.silvinovieira.d3_spring_profissional.entities.Client;
import com.silvinovieira.d3_spring_profissional.repositories.ClientRepositories;
import com.silvinovieira.d3_spring_profissional.services.exceptions.DatabaseException;
import com.silvinovieira.d3_spring_profissional.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        copyDtoToEntity(dto, client);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        Client client = repository.getReferenceById(id);
        copyDtoToEntity(dto, client);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("erro de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }

}
