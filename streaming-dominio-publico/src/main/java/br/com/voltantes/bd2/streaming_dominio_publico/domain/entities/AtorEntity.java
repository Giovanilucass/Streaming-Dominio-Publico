package br.com.voltantes.bd2.streaming_dominio_publico.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Ator")
public class AtorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Equivalente ao Serial
    private Long id_ator;

    @NotNull
    private String nome;

    private LocalDate data_nascimento;

    private String local_nascimento;

    private String descricao;

}