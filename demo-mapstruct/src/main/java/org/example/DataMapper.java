package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface DataMapper {
    DataMapper instance = getMapper(DataMapper.class);

    @Mapping(source = "text", target = "text")
    void transferData(MyDto myDto, @MappingTarget MyDomain myDomain);
}
