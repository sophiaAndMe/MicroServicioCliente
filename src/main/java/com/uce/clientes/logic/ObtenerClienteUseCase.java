package com.uce.clientes.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.clientes.controllers.converts.EntityClienteConvertes;
import com.uce.clientes.controllers.data.ClienteUI;
import com.uce.clientes.data.repositories.UserRepository;
import com.uce.clientes.logic.validators.Result;

import java.util.Optional;

@Service
public class ObtenerClienteUseCase {

    @Autowired
    private UserRepository userRepository;

    public Result<ClienteUI> execute(int id) {
        try {
            // Uso de Optional para manejo funcional de nulidad
            return userRepository.findById(id)
                .map(EntityClienteConvertes::ClienteEntitytoUI) // Si existe, convierte
                .map(Result::success) // Y envuelve en Success
                .orElseGet(() -> Result.failure(new RuntimeException("Cliente no encontrado con ID: " + id))); // Si no, Failure

        } catch (Exception e) {
            return Result.failure(e);
        }
    }
}