package com.bci.demo.user.business;

import com.bci.demo.user.model.api.UserRequest;
import com.bci.demo.user.model.api.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

}
