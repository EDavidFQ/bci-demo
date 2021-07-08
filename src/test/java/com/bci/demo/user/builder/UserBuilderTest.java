package com.bci.demo.user.builder;

import static org.assertj.core.api.Assertions.assertThat;

import com.bci.demo.user.model.api.UserRequest;
import com.bci.demo.user.model.api.UserResponse;
import com.bci.demo.user.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UserBuilderTest {

    @InjectMocks
    private UserBuilder userBuilder;

    @Test
    public void buildUserTest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setPassword("password");
        User user = userBuilder.buildUser(userRequest);

        assertThat(user.getPassword()).isEqualTo(userRequest.getPassword());
    }

    @Test
    public void buildUserResponseTest() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setActive(true);
        UserResponse userResponse = userBuilder.buildUserResponse(user);

        assertThat(userResponse.getId()).isEqualTo(user.getId().toString());
    }

}
