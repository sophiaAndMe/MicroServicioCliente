package com.uce.clientes.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Address{

    @Id
    public int id_adress;
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Ubicacion geo;
}