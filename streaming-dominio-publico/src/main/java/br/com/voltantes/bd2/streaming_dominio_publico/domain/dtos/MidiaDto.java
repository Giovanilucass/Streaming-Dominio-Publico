package br.com.voltantes.bd2.streaming_dominio_publico.domain.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MidiaDto {
        
    private Long id_midia;

    private String titulo;

    private String descricao;

    private LocalDate data_de_lancamento;

    private Long duracao_segundos;

    private String nacionalidade;

}
