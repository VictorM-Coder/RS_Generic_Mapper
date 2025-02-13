package org.example.final_mapper_pattern.mappers;

import org.example.final_mapper_pattern.dtos.CourseDto;
import org.example.final_mapper_pattern.models.CourseModel;

public class CourseMapper implements GenericMapperSimple<CourseModel, CourseDto>{
    @Override
    public CourseModel toModel(CourseDto dto) {
        CourseModel courseModel = new CourseModel();
        courseModel.setName(dto.name());
        courseModel.setDescription(dto.description());
        courseModel.setPrice(dto.price());
        return courseModel;
    }

    @Override
    public CourseDto toDto(CourseModel model) {
        return new CourseDto(
                model.getName(),
                model.getDescription(),
                model.getPrice()
        );
    }
}
