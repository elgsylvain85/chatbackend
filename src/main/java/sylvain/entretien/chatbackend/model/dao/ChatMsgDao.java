package sylvain.entretien.chatbackend.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sylvain.entretien.chatbackend.model.entity.ChatMsg;

// @Repository
public interface ChatMsgDao extends JpaRepository<ChatMsg, String>{
    
}
