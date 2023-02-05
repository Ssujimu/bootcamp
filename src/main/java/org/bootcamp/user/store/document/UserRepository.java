package org.bootcamp.user.store.document;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDoc, String> {
    //
    // 로그인 id, pw 찾기
    Optional<UserDoc> findByIdAndPw(String id, String pw);

}
