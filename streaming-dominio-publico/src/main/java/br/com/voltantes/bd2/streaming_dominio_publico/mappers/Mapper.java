package br.com.voltantes.bd2.streaming_dominio_publico.mappers;

public interface Mapper<A, B> {
    public B mapTo(A a);

    public A mapFrom(B b);

}
