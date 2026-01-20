package com.uce.clientes.controllers.converts;

import org.springframework.stereotype.Component; // Usar Component o Service

import com.uce.clientes.controllers.data.ClienteUI;
import com.uce.clientes.data.entities.UserEntity;

@Component
public class EntityClienteConvertes {

    // Función pura: Transforma Entidad -> UI
    public static ClienteUI ClienteEntitytoUI(UserEntity userEntity){
        if (userEntity == null) return null;
        return new ClienteUI(
            userEntity.id,
            userEntity.name,
            userEntity.username,
            userEntity.email,
            userEntity.address,
            userEntity.phone,
            userEntity.website,
            userEntity.company
        );
    }

    // Función pura: Transforma UI -> Entidad
    public static UserEntity ClienteUItoEntity(ClienteUI clienteUI){
        if (clienteUI == null) return null;
        UserEntity entity = new UserEntity();
        entity.id = clienteUI.getId(); // O generar uno si es autoincremental
        entity.name = clienteUI.getName();
        entity.username = clienteUI.getUsername();
        entity.email = clienteUI.getEmail();
        entity.address = clienteUI.getAddress();
        entity.phone = clienteUI.getPhone();
        entity.website = clienteUI.getWebsite();
        entity.company = clienteUI.getCompany();
        return entity;
    }
}