package br.com.voltantes.bd2.streaming_dominio_publico.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.AtorEntity;


//java Conversor de SQL pra Java
@Repository
public interface AtorRepository extends CrudRepository<AtorRepository, Long>
{
    Iterable<AtorEntity> ageLessThan(int age);      
    @Query("SELECT a FROM AutorEntity a WHERE a.age > ?1")
    Iterable<AtorEntity> findAtorWithAgeGreatherThan(int age);
 }

    
