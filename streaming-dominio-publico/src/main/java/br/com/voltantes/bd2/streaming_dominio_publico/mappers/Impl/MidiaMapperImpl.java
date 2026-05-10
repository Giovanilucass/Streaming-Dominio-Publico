package br.com.voltantes.bd2.streaming_dominio_publico.mappers.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.dtos.MidiaDto;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.mappers.Mapper;

@Component
public class MidiaMapperImpl implements Mapper<MidiaEntity, MidiaDto>{

    @Autowired
    private ModelMapper modelMapper;

    public MidiaMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MidiaDto mapTo(MidiaEntity midiaEntity) {
        return modelMapper.map(midiaEntity, MidiaDto.class);
    }

    @Override
    public MidiaEntity mapFrom(MidiaDto midiaDto) {
        return modelMapper.map(midiaDto, MidiaEntity.class);
    }



}
