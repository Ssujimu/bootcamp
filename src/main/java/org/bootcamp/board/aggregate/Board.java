package org.bootcamp.board.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.board.command.BoardCreate;
import org.bootcamp.board.command.BoardDelete;
import org.bootcamp.util.IdName;

// 계층 간에 데이터 교환을 위한 객체 , 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체 등이 이들을 이야기
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    //
    private String boardId;
    private String title;
    private String content;
    private IdName user;
    private String registerTime;
    private int sequence;

    private BoardType boardType;

    public Board(BoardCreate command) {
        //
        this.title = command.getTitle();
        this.content = command.getContent();
        this.boardType = command.getBoardType();
        this.user = command.getUser();
        this.registerTime = String.valueOf(System.currentTimeMillis());
        this.sequence = 0;
    }

    public Board(BoardDelete command) {
        //
        this.boardId = command.getBoardId();
    }

}
