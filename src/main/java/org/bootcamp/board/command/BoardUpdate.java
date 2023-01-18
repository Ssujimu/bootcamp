package org.bootcamp.board.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.board.aggregate.vo.BoardType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdate {
    //
    transient private String boardId;
    private String title;
    private String content;
    private BoardType boardType;
}
