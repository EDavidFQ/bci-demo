package com.bci.demo.user.business.impl;

import com.azure.storage.queue.QueueClient;
import com.bci.demo.exception.RegisteredEmailException;
import com.bci.demo.user.builder.UserBuilder;
import com.bci.demo.user.business.UserService;
import com.bci.demo.user.model.api.UserRequest;
import com.bci.demo.user.model.api.UserResponse;
import com.bci.demo.user.model.entity.User;
import com.bci.demo.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserBuilder userBuilder;
    private final UserRepository userRepository;
    private final QueueClient queueClient;

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        this.validateEmail(userRequest.getEmail());
        User user = userRepository.save(userBuilder.buildUser(userRequest));
        log.info("Email {} has been saved", user.getEmail());
        this.sendMessage(user.getEmail(), userRequest.getPhones().get(0).getNumber());

        return userBuilder.buildUserResponse(user);
    }

    private void validateEmail(final String email) {
        if (userRepository.findFirstByEmail(email) != null) {
            throw new RegisteredEmailException(email);
        }
    }

    @Async
    private void sendMessage(final String email, final String phoneNumber) {
        StringBuilder message = new StringBuilder();
        message.append("{\"email\": \"").append(email).append("\", ");
        message.append("\"phone\": \"").append(phoneNumber).append("\"");
        message.append("}");
        queueClient.sendMessage(message.toString());
        log.info("Message has been sent to the queue");
    }

}
