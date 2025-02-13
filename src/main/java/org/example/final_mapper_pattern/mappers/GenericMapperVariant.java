package org.example.final_mapper_pattern.mappers;

/**
 *
 * @param <M> Model
 * @param <D> DTO for Request
 * @param <R> DTO for Respsonse
 */
public interface GenericMapperVariant<M, D, R> {
    M toModel(D request);
    R toDto(M model);
}
