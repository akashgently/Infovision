package com.AuthService.controller;

import com.AuthService.dto.*;
import com.AuthService.entity.UserDE;
import com.AuthService.exception.ExistingUserFoundException;
import com.AuthService.exception.MissingFieldException;
import com.AuthService.exception.NotFoundException;
import com.AuthService.jwt.JwtUtils;
import com.AuthService.repository.UserRepository;
import com.AuthService.service.UserDetailsImpl;
import com.AuthService.service.UserService;
import com.AuthService.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody SignUpRequestDTO signUpRequestDTO)
            throws MissingFieldException, ExistingUserFoundException {

        try {
            ValidateUserFields validateUserFields = new ValidateUserFields();
            validateUserFields.validateSignUpFields(signUpRequestDTO);
            UserDE userRegistered = null;

            if (userService.getByEmailIdAndMobileNumber(signUpRequestDTO.getEmailId(), signUpRequestDTO.getMobile()) == null) {
                userRegistered = userService.saveUser(signUpRequestDTO);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new SavedRecordResponseDto(new ResponseDto(201, "Record saved successfully")));
            } else {
                throw new ExistingUserFoundException("User already exists");
            }
        } catch (ExistingUserFoundException e) {
            throw new ExistingUserFoundException(e.getMessage());
        } catch (MissingFieldException e) {
            throw new MissingFieldException("Fields missing");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmailId(), loginRequestDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        UserDE user = userService.getByEmailId(loginRequestDTO.getEmailId());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new JwtResponse(jwtCookie.getValue(), user.getUserType()));
    }
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDto) {

        UserDE user = userService.getByEmailId(changePasswordDto.getEmailId());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto(404, "User not found"));
        }
        user.setPassword(passwordEncoder.encode(changePasswordDto.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(new ResponseDto(200, "Password updated successfully"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDE>> getAllDetails() {
        List<UserDE> usersResponses = userService.getAllDetails();
        return ResponseEntity.ok(usersResponses);
    }
}

