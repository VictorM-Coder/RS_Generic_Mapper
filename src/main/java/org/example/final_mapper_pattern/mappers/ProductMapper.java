package org.example.final_mapper_pattern.mappers;

import org.example.final_mapper_pattern.dtos.ProductRequestDto;
import org.example.final_mapper_pattern.dtos.ProductResponseDto;
import org.example.final_mapper_pattern.models.ProductModel;

public class ProductMapper implements GenericMapperVariant<ProductModel, ProductRequestDto, ProductResponseDto>{
    @Override
    public ProductModel toModel(ProductRequestDto dto) {
        return new ProductModel(dto.name(), dto.price());
    }

    @Override
    public ProductResponseDto toDto(ProductModel model) {
        //In this example, the value of the name field is transformed before being returned
        String transformedData = transformData(model.getName());
        return new ProductResponseDto(transformedData, model.getPrice());
    }

    private String transformData(String data) {
        return data.toUpperCase();
    }
}
