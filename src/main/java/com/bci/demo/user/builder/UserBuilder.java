package com.bci.demo.user.builder;

import com.bci.demo.user.model.api.UserRequest;
import com.bci.demo.user.model.api.UserResponse;
import com.bci.demo.user.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class UserBuilder {

    public User buildUser(final UserRequest userRequest) {
        Date date = Calendar.getInstance().getTime();

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setCreated(date);
        user.setLastLogin(date);
        user.setToken(UUID.randomUUID().toString());
        user.setActive(Boolean.TRUE);

        return user;
    }

    public UserResponse buildUserResponse(final User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId().toString());
        userResponse.setToken(user.getToken());
        userResponse.setActive(user.getActive());
        userResponse.setCreated(user.getCreated());
        userResponse.setModified(user.getModified());
        userResponse.setLastLogin(user.getLastLogin());
        return userResponse;
    }

}
