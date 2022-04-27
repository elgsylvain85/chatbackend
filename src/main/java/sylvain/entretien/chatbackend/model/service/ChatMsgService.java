package sylvain.entretien.chatbackend.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sylvain.entretien.chatbackend.model.entity.ChatMsg;

// @Service
public interface ChatMsgService {

    void newMsg(String content, String userId);

    List<ChatMsg> allMsg(String userId);
    
}
