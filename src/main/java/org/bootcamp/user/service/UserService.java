package org.bootcamp.user.service;

import org.bootcamp.user.aggregate.User;
import org.bootcamp.user.command.UserCreate;
import org.bootcamp.user.store.UserStore;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //
    private final UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

    public void create(UserCreate command) {
        //
        User user = new User(command);
        this.userStore.create(user);
    }

    public User query(String id) {
        return this.userStore.query(id);
    }
}
