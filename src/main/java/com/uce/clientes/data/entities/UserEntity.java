package com.uce.clientes.data.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserEntity {
    

    // NECESITO QUE ESTE MICROSERVICIO AL MOMENTO DE CONSUMIRLO ME DEVUELVA CLIENTES 
    // SUPONGO QUE DEBO DARLES SERIALIZADOS

    @Id
    public int id;
    public String name;
    public String username;
    public String email;
    public String phone;
    public String website;
    @OneToOne(cascade = CascadeType.ALL) // Necesario para guardar la dirección al guardar el usuario
    public Address address;

    @OneToOne(cascade = CascadeType.ALL)
    public Company company;
}
