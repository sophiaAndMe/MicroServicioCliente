package com.uce.clientes.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.clientes.controllers.converts.EntityClienteConvertes;
import com.uce.clientes.controllers.data.ClienteUI;
import com.uce.clientes.data.entities.UserEntity;
import com.uce.clientes.data.repositories.UserRepository;
import com.uce.clientes.logic.validators.Result;

@Service
public class RegistrarUsuarioUseCase {

    @Autowired
    private UserRepository userRepository;

    public Result<ClienteUI> execute(ClienteUI nuevoCliente) {
        // Enfoque funcional: Try-catch encapsulado en el Result
        try {
            // 1. Validar (Opcional, se podría extraer a un Validator separado)
            if (nuevoCliente.getEmail() == null || nuevoCliente.getName() == null) {
                return Result.failure(new IllegalArgumentException("El nombre y email son obligatorios"));
            }

            // 2. Convertir UI -> Entity
            UserEntity entity = EntityClienteConvertes.ClienteUItoEntity(nuevoCliente);

            // 3. Persistir
            // Nota: Asegúrate de que tus entidades Address/Company tengan las relaciones JPA correctas (@OneToOne cascade)
            UserEntity savedEntity = userRepository.save(entity);

            // 4. Retornar éxito transformando de nuevo a UI
            return Result.success(EntityClienteConvertes.ClienteEntitytoUI(savedEntity));

        } catch (Exception e) {
            return Result.failure(e);
        }
    }
}
