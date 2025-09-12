package com.fitness.activityservice.mapper;

import java.util.List;

public interface ActivityMapper<E, D> {

    E dtoToEntity(D dto);
    D entityToDto(E entity);

    default List<D> entityToDtoList(List<E> entities) {
        if(entities == null || entities.isEmpty()) return null;
        return entities.stream().map(this::entityToDto).toList();
    }

    default List<E> dtoToEntityList(List<D> dtos) {
        if(dtos == null || dtos.isEmpty()) return null;
        return dtos.stream().map(this::dtoToEntity).toList();
    }
}
