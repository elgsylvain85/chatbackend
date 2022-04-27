package sylvain.entretien.chatbackend.model.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
public class ChatUser {

    @Id
    private String id;
    @Column(unique = true)
    private String userName;
    private String userPassword;

    public ChatUser(){
        this.id = UUID.randomUUID().toString();
    }
    
}
