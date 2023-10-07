package de.tramotech.demobackend.mapper;

import de.tramotech.demobackend.dto.UserDto;
import de.tramotech.demobackend.model.User;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.factory.Mappers.getMapper;

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
