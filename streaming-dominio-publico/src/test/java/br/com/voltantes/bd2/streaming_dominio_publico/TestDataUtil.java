package br.com.voltantes.bd2.streaming_dominio_publico;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.UsuarioEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.dto.UsuarioDto;

public class TestDataUtil {

    private TestDataUtil() {

    }

    public static UsuarioDto criaUsuarioDtoTeste() {
        return UsuarioDto.builder()
            .id(null)
            .nome("Null")
            .cpf("000.000.000-00")
            .email("nulldasilva@gmail.com")
            .data_nascimento(LocalDate.parse("2001-01-01"))
            .data_criacao(LocalDateTime.now())
            .build();
    }

    public static UsuarioEntity criaUsuarioTesteA() {
        return UsuarioEntity.builder()
            .id(null)
            .nome("Jorge")
            .cpf("123.456.789-00")
            .email("jorgedasilva@gmail.com")
            .senha("senha1234")
            .data_nascimento(LocalDate.parse("2001-09-11"))
            .data_criacao(LocalDateTime.now())
            .build();
    }

    public static UsuarioEntity criaUsuarioTesteB() {
        return UsuarioEntity.builder()
            .id(null)
            .nome("Emilio")
            .cpf("987.654.321-00")
            .email("emiliodasilva@gmail.com")
            .senha("1234senha")
            .data_nascimento(LocalDate.parse("2001-09-12"))
            .data_criacao(LocalDateTime.now())
            .build();
    }

}
