package com.uce.clientes.data.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;    // Importante para la relación
import jakarta.persistence.OneToOne;

@Entity
public class Address{

    @Id
    public int id_adress;
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "geo_id") // Crea una columna 'geo_id' en la tabla Address que apunta a Ubicacion
    public Ubicacion geo;
}