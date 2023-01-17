package org.bootcamp.board.aggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.util.IdName;

// vo = 특정 값을 나타내는 객체 -> vo에는 로직 o
// dto = 데이터 교환을 위한 객체 -> dto에는 로직 x
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    //
    private String commentId;
    private String comment;
    private IdName user;
    private String registerTime;
}
