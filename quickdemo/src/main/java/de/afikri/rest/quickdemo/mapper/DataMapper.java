package de.afikri.rest.quickdemo.mapper;

import de.afikri.rest.quickdemo.dto.UserDto;
import de.afikri.rest.quickdemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface DataMapper {
    DataMapper instance = getMapper(DataMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    void transferData(UserDto userDto, @MappingTarget User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    void transferData(User user, @MappingTarget UserDto userDto);
}
