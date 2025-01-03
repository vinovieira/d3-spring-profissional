package com.silvinovieira.d3_spring_profissional.dto;

import com.silvinovieira.d3_spring_profissional.entities.Client;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Long id, Integer children, LocalDate birthDate, Double income, String cpf, String name) {
        this.id = id;
        this.children = children;
        this.birthDate = birthDate;
        this.income = income;
        this.cpf = cpf;
        this.name = name;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
