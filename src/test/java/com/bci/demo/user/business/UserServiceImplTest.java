package com.bci.demo.user.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import com.azure.storage.queue.QueueClient;
import com.bci.demo.user.builder.UserBuilder;
import com.bci.demo.user.business.impl.UserServiceImpl;
import com.bci.demo.user.model.api.PhoneRequest;
import com.bci.demo.user.model.api.UserRequest;
import com.bci.demo.user.model.api.UserResponse;
import com.bci.demo.user.model.entity.Phone;
import com.bci.demo.user.model.entity.User;
import com.bci.demo.user.repository.PhoneRepository;
import com.bci.demo.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserBuilder userBuilder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private QueueClient queueClient;

    @Test
    public void createUserTest() {

        UUID uuid = UUID.randomUUID();
        User user = new User();
        user.setId(uuid);

        List<Phone> phones = new ArrayList<>();

        UserResponse userResponse = new UserResponse();
        userResponse.setId(uuid.toString());

        when(userRepository.findFirstByEmail(anyString())).thenReturn(null);
        when(userBuilder.buildUser(any())).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);
        when(userBuilder.getPhones(anyList())).thenReturn(phones);
        when(phoneRepository.saveAll(anyList())).thenReturn(phones);
        when(queueClient.sendMessage(anyString())).thenReturn(null);
        when(userBuilder.buildUserResponse(any())).thenReturn(userResponse);

        UserRequest userRequest = new UserRequest();

        List<PhoneRequest> phoneRequests = new ArrayList<>();
        PhoneRequest phoneRequest = new PhoneRequest();
        phoneRequest.setNumber("987654321");
        phoneRequests.add(phoneRequest);

        userRequest.setEmail("star@gmail.com");
        userRequest.setPhones(phoneRequests);
        UserResponse result = userService.createUser(userRequest);

        assertThat(result.getId()).isEqualTo(uuid.toString());
    }

}
