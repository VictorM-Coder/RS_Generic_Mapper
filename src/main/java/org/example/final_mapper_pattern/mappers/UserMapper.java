package org.example.final_mapper_pattern.mappers;

import org.example.final_mapper_pattern.dtos.UserRequestDto;
import org.example.final_mapper_pattern.dtos.UserResponseDto;
import org.example.final_mapper_pattern.models.UserModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserMapper implements GenericMapperVariant<UserModel, UserRequestDto, UserResponseDto> {
    @Override
    public UserModel toModel(UserRequestDto dto) {
        //In this example, the password field value must be encrypted before saved
        return new UserModel(
                dto.name(),
                dto.lastname(),
                dto.email(),
                encryptPassword(dto.password())
        );
    }

    @Override
    public UserResponseDto toDto(UserModel model) {
        return new UserResponseDto(
                model.getName(), model.getLastname(), model.getEmail()
        );
    }

    private static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }
}
