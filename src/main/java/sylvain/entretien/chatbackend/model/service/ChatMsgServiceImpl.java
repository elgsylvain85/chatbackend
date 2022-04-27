package sylvain.entretien.chatbackend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sylvain.entretien.chatbackend.model.dao.ChatMsgDao;
import sylvain.entretien.chatbackend.model.entity.ChatMsg;

@Service
public class ChatMsgServiceImpl implements ChatMsgService{

    @Autowired
    ChatUserService chatUserService;
    @Autowired
    ChatMsgDao chatMsgDao;

    @Override
    public void newMsg(String content, String userId){


        var oChatUser = chatUserService.findById(userId);

        if(oChatUser.isPresent()){
            ChatMsg chatMsg = new ChatMsg();
            chatMsg.setContent(content);

            chatMsg.setChatUser(oChatUser.get());

            chatMsgDao.save(chatMsg);


        }else{
            throw new RuntimeException("User not found");
        }

        
        
    }

    public List<ChatMsg> allMsg(String userId){

        // List<ChatMsg> result = new ArrayList();
        

        var oChatUser = chatUserService.findById(userId);

        if(oChatUser.isPresent()){

            // result.addAll(this.chatMsgDao.findAll());
            return this.chatMsgDao.findAll();


         }else{
            throw new RuntimeException("User not found");
        }

        // return result;

    }
}
