package sylvain.entretien.chatbackend.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sylvain.entretien.chatbackend.model.dao.ChatUserDao;
import sylvain.entretien.chatbackend.model.entity.ChatUser;

@Service
public class ChatUserServiceImpl implements ChatUserService{

    @Autowired
    ChatUserDao chatUserDao;

    public ChatUser newUser(String login, String password){

        ChatUser chatUser = new ChatUser();
        chatUser.setUserName(login);
        chatUser.setUserPassword(password);

        chatUserDao.save(chatUser);

        return chatUser;

    }

    public ChatUser login(String login, String password){
        ChatUser chatUser = chatUserDao.findByUserNameAndUserPassword(login, password);

        if(chatUser == null){
            throw new RuntimeException("login error");
        }else return chatUser;
    }

    public Optional<ChatUser> findById(String id){
        return this.chatUserDao.findById(id);
    }
    
}
