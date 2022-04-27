package sylvain.entretien.chatbackend.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sylvain.entretien.chatbackend.model.entity.ChatUser;

public interface ChatUserDao extends JpaRepository<ChatUser, String>{

    ChatUser findByUserNameAndUserPassword(String userName, String userPassword);
    
}
