package com.uce.clientes.controllers.converts;

import org.springframework.stereotype.Service;

import com.uce.clientes.controllers.data.ClienteUI;
import com.uce.clientes.data.entities.UserEntity;

@Service
public class EntityClienteConvertes {

    public static ClienteUI ClienteEntitytoUI(UserEntity userEntity){
        return new ClienteUI(userEntity.id,
            userEntity.name,
            userEntity.username,
            userEntity.email,
            userEntity.address,
            userEntity.phone,
            userEntity.website,
            userEntity.company
        );
    }
    
}
