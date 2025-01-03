package com.silvinovieira.d3_spring_profissional.controllers;

import com.silvinovieira.d3_spring_profissional.dto.ClientDTO;
import com.silvinovieira.d3_spring_profissional.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
