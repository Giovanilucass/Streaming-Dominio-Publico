package br.com.voltantes.bd2.streaming_dominio_publico.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.dto.AtorDto;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.AtorEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.services.AtorService;
import br.com.voltantes.bd2.streaming_dominio_publico.Mappers.Mapper;


@RestController
public class AtorController {

    @Autowired 
    private final AtorService atorService;

    @Autowired 
    private final Mapper<AtorEntity, AtorDto> atorMapper;

    public AtorController (AtorService atorservice, Mapper<AtorEntity, AtorDto> atorMapper)
    {
        this.atorService = atorService;
        this.atorMapper = atorMapper;
    }


    @PostMapping(path="atores")
    public ResponseEntity<AtorDto> postNewAtor(@RequestBody final AtorDto ator)
    {
        
