package br.com.voltantes.bd2.streaming_dominio_publico.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.repositories.MidiaRepository;
import br.com.voltantes.bd2.streaming_dominio_publico.services.MidiaService;

@Service
public class MidiaServiceImpl implements MidiaService{

    @Autowired
    private MidiaRepository midiaRepository;

    public MidiaServiceImpl(MidiaRepository midiaRepository) {
        this.midiaRepository = midiaRepository;
    }

    @Override
    public MidiaEntity save(MidiaEntity midiaEntity) {
        return midiaRepository.save(midiaEntity);
    }

    @Override
    public Page<MidiaEntity> findAllMidia(Pageable pageable) {
        return midiaRepository.findAll(pageable);
    }

    @Override
    public Optional<MidiaEntity> findOne(long id) {
        return midiaRepository.findById(id);
    }

}
