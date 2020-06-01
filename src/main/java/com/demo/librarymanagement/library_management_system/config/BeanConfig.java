package com.demo.librarymanagement.library_management_system.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    /*@Bean
    public MapperManager mapperManager(){
        return new MapperManager() {
            @Mappings({
                    @Mapping(target = "personId", source = "entity.personId"),
                    @Mapping(target = "firstName", source = "entity.firstName"),
                    @Mapping(target = "lastName", source = "entity.lastName"),
                    @Mapping(target = "contactInfo", source = "entity.contactInfo"),
                    @Mapping(target = "book", source = "entity.book")
            })
            @Override
            public PersonEntity requestToEntity(PersonRequest entity) {
                return null;
            }

            @Override
            public PersonResponse entityToResponse(PersonEntity entity) {
                return null;
            }
        };
    }*/
}
