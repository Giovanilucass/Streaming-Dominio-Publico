package br.com.voltantes.bd2.streaming_dominio_publico.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.dtos.MidiaDto;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.mappers.Mapper;
import br.com.voltantes.bd2.streaming_dominio_publico.services.MidiaService;

@RestController
public class MidiaController {
    
    @Autowired
    private final MidiaService midiaService;

    @Autowired
    private final Mapper<MidiaEntity, MidiaDto> midiaMapper;

    public MidiaController(MidiaService midiaService, Mapper<MidiaEntity, MidiaDto> midiaMapper) {
        this.midiaService = midiaService;
        this.midiaMapper = midiaMapper;
    }

    @PostMapping(path="/midia")
    public ResponseEntity<MidiaDto> postMidia(@RequestBody final MidiaDto midia) {
        MidiaEntity midiaEntity = midiaMapper.mapFrom(midia);
        midiaEntity = midiaService.save(midiaEntity);
        MidiaDto midiaDto = midiaMapper.mapTo(midiaEntity);
        return new ResponseEntity<>(midiaDto, HttpStatus.CREATED);
    }
    

    @GetMapping(path="/midia")    
    public Page<MidiaDto> getAllMidias(Pageable pageable) {
       Page<MidiaEntity> midiaPage = midiaService.findAllMidia(pageable);
       return midiaPage.map(midiaMapper::mapTo);
        
    }

    @GetMapping(path="/midia/{id}")
    public ResponseEntity<MidiaDto> getOneMidia(@PathVariable("id") final long midiaId) {
        Optional<MidiaEntity> midiaEntity = midiaService.findOne(midiaId);
        return midiaEntity.map(midia -> ResponseEntity.ok(midiaMapper.mapTo(midia))
            ).orElse(ResponseEntity.notFound().build());
    }

}
