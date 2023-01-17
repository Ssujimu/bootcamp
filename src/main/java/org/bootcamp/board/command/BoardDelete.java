package org.bootcamp.board.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.util.IdName;

@NoArgsConstructor
@AllArgsConstructor
public class BoardDelete {
    //
    private String boardId;

    public String getBoardId() {
        return this.boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}