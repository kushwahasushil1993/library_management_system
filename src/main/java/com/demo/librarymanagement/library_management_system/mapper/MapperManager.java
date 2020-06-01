/*
package com.demo.librarymanagement.library_management_system.mapper;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import com.demo.librarymanagement.library_management_system.model.PersonRequest;
import com.demo.librarymanagement.library_management_system.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface MapperManager {
    @Mappings({
            @Mapping(target="personId", source="entity.personId"),
            @Mapping(target="firstName", source="entity.firstName"),
            @Mapping(target="lastName", source="entity.lastName"),
            @Mapping(target="contactInfo", source="entity.contactInfo"),
            @Mapping(target="book", source="entity.book")
    })
    PersonEntity requestToEntity(PersonRequest entity);

    @Mappings({
            @Mapping(target="personId", source="entity.personId"),
            @Mapping(target="firstName", source="entity.firstName"),
            @Mapping(target="lastName", source="entity.lastName"),
            @Mapping(target="contactInfo", source="entity.contactInfo"),
            @Mapping(target="book", source="entity.book")
    })
    PersonResponse entityToResponse(PersonEntity entity);
}
*/
