package com.silvinovieira.d3_spring_profissional.repositories;

import com.silvinovieira.d3_spring_profissional.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositories extends JpaRepository<Client, Long> {
}
