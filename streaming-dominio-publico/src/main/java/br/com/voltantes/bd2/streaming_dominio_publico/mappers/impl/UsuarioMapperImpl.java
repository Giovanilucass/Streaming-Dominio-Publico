package br.com.voltantes.bd2.streaming_dominio_publico.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.UsuarioEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.dto.UsuarioDto;
import br.com.voltantes.bd2.streaming_dominio_publico.mappers.Mapper;

public class UsuarioMapperImpl implements Mapper<UsuarioEntity, UsuarioDto>{

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UsuarioEntity mapFrom(UsuarioDto usuarioDto) {
        return modelMapper.map(usuarioDto, UsuarioEntity.class);
    }

    @Override
    public UsuarioDto mapTo(UsuarioEntity usuarioEntity) {
        return modelMapper.map(usuarioEntity, UsuarioDto.class);
    }

}
