package br.com.voltantes.bd2.streaming_dominio_publico.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;

@Repository
public interface MidiaRepository extends CrudRepository<MidiaEntity, Long>, PagingAndSortingRepository<MidiaEntity, Long>{

}
