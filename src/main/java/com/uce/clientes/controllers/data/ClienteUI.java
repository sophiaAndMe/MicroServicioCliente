package com.uce.clientes.controllers.data;


import java.beans.JavaBean;

import com.uce.clientes.data.entities.Address;
import com.uce.clientes.data.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JavaBean
public class ClienteUI {


    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
    
}
