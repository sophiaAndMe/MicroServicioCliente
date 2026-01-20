package com.uce.clientes.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Company{

    @Id
    public int id_company;
    public String name;
    public String catchPhrase;
    public String bs;
}