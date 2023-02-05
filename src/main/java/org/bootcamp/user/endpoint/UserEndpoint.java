package org.bootcamp.user.endpoint;

import org.bootcamp.user.aggregate.User;
import org.bootcamp.user.command.UserCreate;
import org.bootcamp.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEndpoint {
    //

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void create(@RequestBody UserCreate command) {
        //
        this.userService.create(command);
    }

    @GetMapping("/{id}")
    public User query(@PathVariable String id, @RequestParam String pw) {
        // 로그인 시 id와 pw 확인
        return this.userService.query(id, pw);
    }
}
