package org.bootcamp.board.store.document;

import org.bootcamp.board.aggregate.Board;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// query문 만들기~
public interface BoardRepository extends MongoRepository<BoardDoc, String> {
    //
    List<BoardDoc> findAllByBoardType(BoardType boardType);
}
