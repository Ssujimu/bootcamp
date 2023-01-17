package org.bootcamp.board.store.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.board.aggregate.Board;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.util.IdName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Model 객체 생성
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("BOARD")
public class BoardDoc {
    //
    @Id
    private String boardId;
    private String title;
    private String content;
    private IdName user;
    private String registerTime;
    private int sequence;

    private BoardType boardType;

    public BoardDoc(Board board) {
        //
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.user = board.getUser();
        this.registerTime = board.getRegisterTime();
        this.sequence = board.getSequence();
        this.boardType = board.getBoardType();
    }

    public Board toBoard() {
        //
        return new Board(
                this.boardId,
                this.title,
                this.content,
                this.user,
                this.registerTime,
                this.sequence,
                this.boardType
        );
    }
}
