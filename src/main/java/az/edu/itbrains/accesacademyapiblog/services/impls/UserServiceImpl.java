package az.edu.itbrains.accesacademyapiblog.services.impls;

import az.edu.itbrains.accesacademyapiblog.dtos.authDto.RegisterDto;
import az.edu.itbrains.accesacademyapiblog.models.User;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiResponse;
import az.edu.itbrains.accesacademyapiblog.repositories.UserRepository;
import az.edu.itbrains.accesacademyapiblog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByEmail(String email) {
        User user= userRepository.findByEmail(email);
        return user;
    }

    @Override
    public ApiResponse registerUser(RegisterDto registerDto) {

        try {
            User findUser=userRepository.findByEmail(registerDto.getEmail());
            if(findUser!=null){
                return new ApiResponse(false, HttpStatus.BAD_REQUEST,"email already exist");
            }
            User user=modelMapper.map(registerDto,User.class);
            String password= passwordEncoder.encode(registerDto.getPassword());
            user.setPassword(password);
            user.setConfirmationToken("test");
            userRepository.save(user);
            return new ApiResponse(true,HttpStatus.OK,"registered succesfuly");

        }catch (Exception e){
            return new ApiResponse(false,e.getMessage());
        }
    }
}
