package org.example.final_mapper_pattern.mappers;

public interface GenericMapperSimple<M, D> {
    M toModel(D dto);
    D toDto(M model);
}
