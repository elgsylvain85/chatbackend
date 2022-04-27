package sylvain.entretien.chatbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sylvain.entretien.chatbackend.model.entity.ChatMsg;
import sylvain.entretien.chatbackend.model.entity.ChatUser;
import sylvain.entretien.chatbackend.model.service.ChatMsgService;
import sylvain.entretien.chatbackend.model.service.ChatUserService;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    ChatUserService userChatService;
    @Autowired
    ChatMsgService msgChatService;

    @PostMapping("newuser")
    public ResponseEntity<ChatUser> newUser(@RequestParam(name = "username") String userName,
            @RequestParam(name = "password") String password) {
        try {

            var chatUser = this.userChatService.newUser(userName, password);

            return ResponseEntity.ok().body(chatUser);

        } catch (Exception ex) {
            ex.printStackTrace();

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("userlogin")
    public ResponseEntity<ChatUser> userLogin(@RequestParam(name = "username") String userName,
            @RequestParam(name = "password") String password) {
        try {

            var chatUser = this.userChatService.login(userName, password);

            return ResponseEntity.ok(chatUser);

        } catch (Exception ex) {
            ex.printStackTrace();

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("newmsg")
    public ResponseEntity<Void> newMsg(@RequestParam(name = "content") String content,
            @RequestParam(name = "userid") String userId) {
        try {

            this.msgChatService.newMsg(content, userId);

            return ResponseEntity.ok().build();

        } catch (Exception ex) {
            ex.printStackTrace();

            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("allmsg")
    public ResponseEntity<List<ChatMsg>> allMsg(@RequestParam(name = "userid") String userId) {
        try {

            var data = this.msgChatService.allMsg(userId);

            return ResponseEntity.ok().body(data);

        } catch (Exception ex) {
            ex.printStackTrace();

            return ResponseEntity.badRequest().build();
        }
    }

}
