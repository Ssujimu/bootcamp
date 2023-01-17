package org.bootcamp.board.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.board.aggregate.vo.BoardType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryBoardByBoardType {
    //
    private BoardType boardType;
}
