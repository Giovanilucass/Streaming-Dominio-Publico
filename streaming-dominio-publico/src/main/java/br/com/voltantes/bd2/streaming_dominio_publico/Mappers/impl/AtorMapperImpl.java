package br.com.voltantes.bd2.streaming_dominio_publico.Mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.voltantes.bd2.streaming_dominio_publico.Mappers.Mapper;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.dto.AtorDto;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.AtorEntity;


@Component
public class AtorMapperImpl implements Mapper <AtorEntity, AtorDto> {

    @Autowired
    private ModelMapper modelMapper;

    public AtorMapperImpl(ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

    @Override
    public AtorEntity mapFrom(AtorDto atordto)
    {
        return modelMapper.map(atordto, AtorEntity.class);       
    }

    @Override
    public AtorDto mapTo(AtorEntity atorEntity)
    {
        return modelMapper.map(atorEntity, AtorDto.class);       
    }



    
}
