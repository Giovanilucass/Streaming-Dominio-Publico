package br.com.voltantes.bd2.streaming_dominio_publico.mappers;

public interface Mapper<A, B> {
    B mapTo(A a);

    A mapFrom(B b);
}