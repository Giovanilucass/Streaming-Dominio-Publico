package br.com.voltantes.bd2.streaming_dominio_publico.services;
import java.util.List;
import java.util.Optional;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.AtorEntity;

// Definindo todos os possíveis métodos para o Autor
public interface AtorService{ 

    public AtorEntity saveAtor(AtorEntity autor);

    public AtorEntity saveAtor (long id, AtorEntity autor);

    public List<AtorEntity> findAllAtores();
    //Dado Optional -> Só pega o resultado caso exista, 
    public Optional<AtorEntity> findOneAtor(Long id);

    public boolean exists(Long id);

    public AtorEntity partialUpdate(long id, AtorEntity autor);

    public void delete(long id);

}