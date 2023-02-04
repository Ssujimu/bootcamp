package org.bootcamp.user.store.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.user.aggregate.User;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("USER")
public class UserDoc {
    //
    private String id;
    private String name;
    private String pw;

    public UserDoc(User user) {
        //
        this.id = user.getId();
        this.name = user.getName();
        this.pw = user.getPw();
    }

    public User toUser() {
        //
        return new User(
                this.id,
                this.name,
                this.pw
        );
    }
}
