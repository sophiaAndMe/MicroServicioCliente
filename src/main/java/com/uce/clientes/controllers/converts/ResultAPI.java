package com.uce.clientes.controllers.converts;

import lombok.Data;

@Data
public class ResultAPI {
    private String status;
    private Object result;

    // Constructor para éxito (recibe el objeto resultado)
    public ResultAPI(Object result) {
        this.status = "Success 200 Ok";
        this.result = result;
    }

    // Constructor para error (recibe solo mensaje o estatus)
    public ResultAPI(String status) {
        this.status = status;
        this.result = null;
    }
}