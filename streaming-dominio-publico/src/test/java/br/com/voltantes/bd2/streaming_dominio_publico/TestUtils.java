package br.com.voltantes.bd2.streaming_dominio_publico;

import java.time.LocalDate;
import java.time.Month;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;


public class TestUtils {

    private TestUtils(){}

    public static MidiaEntity criaMidiaEntity1() {
        return MidiaEntity.builder()
        .id_midia(null)
        .titulo("Filme: irado")
        .descricao("blablabla")
        .data_de_lancamento(LocalDate.of(1975, Month.JUNE, 21))
        .duracao_segundos(6040L)
        .nacionalidade("Brasileiro")
        .build();
    }

     public static MidiaEntity criaMidiaEntity2() {
        return MidiaEntity.builder()
        .id_midia(null)
        .titulo("AAA")
        .descricao("blablabla")
        .data_de_lancamento(LocalDate.of(2000, Month.JUNE, 13))
        .duracao_segundos(500L)
        .nacionalidade("Brasileiro")
        .build();
    }

    
     public static MidiaEntity criaMidiaEntity3() {
        return MidiaEntity.builder()
        .id_midia(null)
        .titulo("BBB")
        .descricao("blablabla")
        .data_de_lancamento(LocalDate.of(1600, Month.JUNE, 1))
        .duracao_segundos(200L)
        .nacionalidade("Americano")
        .build();
     }
}
