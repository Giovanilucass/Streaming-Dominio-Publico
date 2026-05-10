package br.com.voltantes.bd2.streaming_dominio_publico.Mappers;

public interface Mapper<A,B> {
    B mapTo(A a);
    
    A mapFrom(B b);
}
