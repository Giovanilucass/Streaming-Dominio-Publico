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

    public AtorController (AtorService atorService, Mapper<AtorEntity, AtorDto> atorMapper)
    {
        this.atorService = atorService;
        this.atorMapper = atorMapper;
    }


    @PostMapping(path="atores")
    public ResponseEntity<AtorDto> postNewAtor(@RequestBody final AtorDto ator) // Cria uma resposta da entidade com base no Post dto do Ator
    {
        AtorEntity atorEntity = atorMapper.mapFrom(ator);
        AtorEntity savedAtorEntity = atorService.saveAtor(atorEntity);
        return new ResponseEntity<>(atorMapper.mapTo(savedAtorEntity), HttpStatus.CREATED);
    }
}

    @GetMapping(path="atores")
    public List<AtorDto> getAllAtores() //Cria Get para mostrar todos os atores
    {
        List<AtorEntity> atores = atorService.findAllAtores();
        return atores.stream()
                .map(atorMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path="atores/{id}")
    public ResponseEntity<AtorDto> getOneAtor(@PathVariable("id") final long atorID) //Cria função que gera resposta com base no Id do ator pesquisado
    {
    Optional<AtorEntity> foundEntity = atorService.findOneAtor(atorID);
    return foundEntity.map(atorEntity -> ResponseEntity.ok(atorMapper.mapTo(atorEntity))
        ).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("atores/{id") //Método PUT é utilizado para atualizar ou substituir um serviço no servidor
    public ResponseEntity<AtorDto> putAtor(@PathVariable("id") final long atorID, @RequestBody final AtorDto atorDto)
    {
        if(!atorService.exists(atorID)) return ResponseEntity.notFound().build();
        AtorEntity atorEntity = atorMapper.mapFrom(atorDto);
        AtorEntity savedAtorEntity = atorService.saveAtor(atorID, atorEntity);
        return ResponseEntity.ok(atorMapper.mapTo(savedAtorEntity));
    }

    @PatchMapping(path = "atores/{id}")
    public ResponseEntity<AtorDto> patchAtor(@PathVariable("id") final long atorID, @RequestBody final AtorDto atorDto)
    {
        if(!atorService.exists(atorID)) return ResponseEntity.notFound().build();
        AtorEntity atorEntity = atorMapper.mapFrom(atorDto);
        atorEntity = atorService.partialUpdate(atorID, atorEntity);

        return ResponseEntity.ok(atorMapper.mapTo(atorEntity));
    }

    @DeleteMapping(path = "atores/{id}")
     public ResponseEntity<AtorDto> patchAtor(@PathVariable("id") final long atorID)
     {
        atorService.delete(atorID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }