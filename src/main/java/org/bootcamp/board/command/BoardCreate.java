package org.bootcamp.board.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.util.IdName;

// 게시판 작성 , dto?
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCreate {
    //
    private String title;
    private String content;
    private BoardType boardType;
    private IdName user;
}
