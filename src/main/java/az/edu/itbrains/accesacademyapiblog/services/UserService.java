package az.edu.itbrains.accesacademyapiblog.services;

import az.edu.itbrains.accesacademyapiblog.dtos.authDto.RegisterDto;
import az.edu.itbrains.accesacademyapiblog.models.User;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiResponse;

public interface UserService {
    User getUserByEmail(String email);
    ApiResponse registerUser(RegisterDto registerDto);
}
