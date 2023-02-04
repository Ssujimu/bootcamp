package org.bootcamp.user.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.user.command.UserCreate;


/**
 *   id가 user가 입력한 id인지 아니면 따로 backend에서 할당하는 식별자인지
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //
    private String id;
    private String name;
    private String pw;

    public User(UserCreate command) {
        //
        this.id = command.getId();
        this.name = command.getName();
        this.pw = command.getPw();
    }
}
