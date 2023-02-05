package org.bootcamp.user.store;

import org.bootcamp.user.aggregate.User;
import org.bootcamp.user.store.document.UserDoc;
import org.bootcamp.user.store.document.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class UserStore {
    //

    private final UserRepository userRepository;

    public UserStore(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        //
        this.userRepository.save(new UserDoc(user));
    }

    public User query(String id, String pw) {
        //
        Optional<UserDoc> doc = this.userRepository.findByIdAndPw(id, pw);

        if (doc.isEmpty()) {
            //
            throw new NoSuchElementException();
        }

        return doc.get().toUser();
    }
}
