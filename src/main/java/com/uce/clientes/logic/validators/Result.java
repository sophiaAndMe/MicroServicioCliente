package com.uce.clientes.logic.validators;

import java.util.function.Function;


// Sealed interface para control estricto de tipos de retorno

public sealed interface Result<T>  {

    record Success<T>(T value) implements Result<T> {}
    record Failure<T>(Throwable exception) implements Result<T> {}

    static <T> Result<T> success(T value) { return new Success<>(value); }
    static <T> Result<T> failure(Throwable exception) { return new Failure<>(exception); }

    default <R> R fold(Function<T, R> onSuccess, Function<Throwable, R> onFailure) {
        if (this instanceof Success<T> s) return onSuccess.apply(s.value());
        return onFailure.apply(((Failure<T>) this).exception());
    }
    
}