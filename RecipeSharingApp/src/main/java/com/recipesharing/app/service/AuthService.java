package com.recipesharing.app.service;

import com.recipesharing.app.dto.SignUpDTO;
import com.recipesharing.app.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignUpDTO signupDTO);
}