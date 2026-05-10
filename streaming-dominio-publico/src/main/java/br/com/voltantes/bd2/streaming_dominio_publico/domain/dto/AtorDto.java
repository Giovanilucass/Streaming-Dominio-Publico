package br.com.voltantes.bd2.streaming_dominio_publico.domain.dto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AtorDto {

    private Long id_autor;

    private String nome;

    private LocalDate data_nascimento;

    private String local_nascimento;

    private String descricao;

}
