package br.com.voltantes.bd2.streaming_dominio_publico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;

public interface MidiaService {

    public MidiaEntity save(MidiaEntity midiaEntity);

    public Page<MidiaEntity> findAllMidia(Pageable pageable);

    public Optional<MidiaEntity> findOne(long id);

}
