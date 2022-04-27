package sylvain.entretien.chatbackend.model.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import sylvain.entretien.chatbackend.model.entity.ChatUser;

// @Service
public interface ChatUserService {
    ChatUser newUser(String login, String password);

    ChatUser login(String login, String password);

    Optional<ChatUser> findById(String id);
}
