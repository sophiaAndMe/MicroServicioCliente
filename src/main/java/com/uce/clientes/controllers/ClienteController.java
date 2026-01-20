package com.uce.clientes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.clientes.controllers.converts.ResultAPI;
import com.uce.clientes.controllers.data.ClienteUI;
import com.uce.clientes.logic.ObtenerClienteUseCase;
import com.uce.clientes.logic.RegistrarUsuarioUseCase;

@RestController
@RequestMapping("/api/users") // Esto define la ruta base. Reservas buscará aquí.
public class ClienteController {

    @Autowired
    private RegistrarUsuarioUseCase registrarUsuarioUseCase;

    @Autowired
    private ObtenerClienteUseCase obtenerClienteUseCase;

    // Endpoint para obtener un cliente (Lo que Reservas consumirá)
    // Ruta final: GET /api/users/{id}
    @GetMapping("/{id}")
    public ResultAPI obtenerCliente(@PathVariable("id") int id) {
        // Llama a tu lógica pura
        return obtenerClienteUseCase.execute(id).fold(
            success -> new ResultAPI(success), // Si tiene éxito, devuelve el cliente
            failure -> new ResultAPI(failure.getMessage()) // Si falla, devuelve el error
        );
    }

    // Endpoint para registrar (Opcional, pero útil para probar)
    @PostMapping("/registro")
    public ResultAPI registrarCliente(@RequestBody ClienteUI clienteUI) {
        return registrarUsuarioUseCase.execute(clienteUI).fold(
            success -> new ResultAPI(success),
            failure -> new ResultAPI(failure.getMessage())
        );
    }
}