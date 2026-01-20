package com.uce.clientes.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ubicacion{

    @Id
    public int id_ubicacion;
    public String lat;
    public String lng;
}