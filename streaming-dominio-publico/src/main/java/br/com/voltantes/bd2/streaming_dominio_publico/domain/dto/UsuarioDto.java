package br.com.voltantes.bd2.streaming_dominio_publico.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {

    private Long id;
    
    private String nome;

    private String cpf;

    private String email;

    private LocalDate data_nascimento;

    private LocalDateTime data_criacao;

}
