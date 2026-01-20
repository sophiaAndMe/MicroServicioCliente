package com.uce.clientes.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    

    // NECESITO QUE ESTE MICROSERVICIO AL MOMENTO DE CONSUMIRLO ME DEVUELVA CLIENTES 
    // SUPONGO QUE DEBO DARLES SERIALIZADOS

    @Id
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

}
