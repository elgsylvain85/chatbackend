package sylvain.entretien.chatbackend.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ChatMsg {

    @Id
    private String id;
    private LocalDateTime createAt;
    private String content;

    @ManyToOne
    private ChatUser chatUser;

    public ChatMsg(){
        this.id = UUID.randomUUID().toString();
        this.createAt = LocalDateTime.now();
    }

    
}
