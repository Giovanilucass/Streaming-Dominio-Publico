package br.com.voltantes.bd2.streaming_dominio_publico.controllers;

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

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.UsuarioEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.services.UsuarioService;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.dto.UsuarioDto;
import br.com.voltantes.bd2.streaming_dominio_publico.mappers.Mapper;

@RestController
public class UsuarioController {
     @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private final Mapper<UsuarioEntity, UsuarioDto> usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, Mapper<UsuarioEntity, UsuarioDto>  usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping(path = "/usuarios")
    public ResponseEntity<UsuarioDto> postNewUsuario(@RequestBody final UsuarioDto usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.mapFrom(usuario);
        UsuarioEntity savedUsuarioEntity =  usuarioService.saveUsuario(usuarioEntity);
        return new ResponseEntity<>(usuarioMapper.mapTo(savedUsuarioEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/usuarios")
    public List<UsuarioDto> getAllUsuarios() {
        List<UsuarioEntity> usuarios = usuarioService.findAllUsuarios();
        return usuarios.stream()
                .map(usuarioMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "usuarios/{id}")
    public ResponseEntity<UsuarioDto> getOneUsuario(@PathVariable("id") final long usuarioID) {
        Optional<UsuarioEntity> foundEntity = usuarioService.findOneUsuario(usuarioID);
        return foundEntity.map(usuarioEntity -> ResponseEntity.ok(usuarioMapper.mapTo(usuarioEntity))
        ).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "usuarios/{id}")
    public ResponseEntity<UsuarioDto> putUsuario(
            @PathVariable("id") final long usuarioID,
            @RequestBody final UsuarioDto usuarioDto) {
        if(!usuarioService.exists(usuarioID)) return ResponseEntity.notFound().build();
        UsuarioEntity usuarioEntity = usuarioMapper.mapFrom(usuarioDto);
        UsuarioEntity savedUsuarioEntity = usuarioService.saveUsuario(usuarioID, usuarioEntity);
        return ResponseEntity.ok(usuarioMapper.mapTo(savedUsuarioEntity));
    }

    @PatchMapping(path = "usuarios/{id}")
    public ResponseEntity<UsuarioDto> patchUsuario(
            @PathVariable("id") final long usuarioID,
            @RequestBody final UsuarioDto usuarioDto) {

        if(!usuarioService.exists(usuarioID)) return ResponseEntity.notFound().build();
        UsuarioEntity usuarioEntity = usuarioMapper.mapFrom(usuarioDto);
        usuarioEntity = usuarioService.partialUpdate(usuarioID, usuarioEntity);
        
        return ResponseEntity.ok(usuarioMapper.mapTo(usuarioEntity));
    }

    @DeleteMapping(path = "usuarios/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") final long usuarioID) {
        usuarioService.delete(usuarioID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
