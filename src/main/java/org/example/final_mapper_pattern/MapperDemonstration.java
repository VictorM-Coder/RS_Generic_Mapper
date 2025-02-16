package org.example.final_mapper_pattern;

import org.example.final_mapper_pattern.dtos.*;
import org.example.final_mapper_pattern.mappers.*;
import org.example.final_mapper_pattern.models.*;

public class MapperDemonstration {

  public static void courseMapperDemo() {
    CourseMapper courseMapper = new CourseMapper();
    CourseDto courseDto = new CourseDto("Java", "Java Springboot Course", 100.0);
    System.out.println("CourseDto: {" + 
    " Description: " + courseDto.description() + ", " +
    "Name: " + courseDto.name() + ", " +
    "Price: " + courseDto.price() + " }");
    
    CourseModel courseModel = courseMapper.toModel(courseDto);
    System.out.println("CourseModel: {" + 
    " Description: " + courseModel.getDescription() + ", " +
    "Name: " + courseModel.getName() + ", " +
    "Price: " + courseModel.getPrice() + " }");
  }

  public static void productMapperDemo() {
    ProductMapper productMapper = new ProductMapper();
    ProductRequestDto productRequestDto = new ProductRequestDto("Java", 100.0);
    System.out.println("ProductRequestDto: {" + 
    " Name: " + productRequestDto.name() + ", " +
    "Price: " + productRequestDto.price() + " }");

    ProductModel productModel = productMapper.toModel(productRequestDto);
    System.out.println("ProductModel: {" + 
    " Name: " + productModel.getName() + ", " +
    "Price: " + productModel.getPrice() + " }");
  }

  public static void userMapperDemo() {
    UserMapper userMapper = new UserMapper();
    UserModel userModel = new UserModel("John Doe", "Doe", "jdoe", "12345#");
    System.out.println("UserModel: {" + 
    " Name: " + userModel.getName() + ", " +
    "Lastname: " + userModel.getLastname() + ", " +
    "Email: " + userModel.getEmail() + ", " +
    "Password: " + "Encrypted Password" + " }");

    UserResponseDto userRequestDto = userMapper.toDto(userModel);
    System.out.println("UserResponseDto: {" + 
    " Name: " + userRequestDto.name() + ", " +
    "Lastname: " + userRequestDto.lastname() + ", " +
    "Email: " + userRequestDto.email() + ", " +
    "Password: " + "Encrypted Password" + " }");
  }
  public static void main(String[] args) {
    courseMapperDemo();
    productMapperDemo();
    userMapperDemo();
  }
}
