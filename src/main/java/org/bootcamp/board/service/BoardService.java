package org.bootcamp.board.service;

import org.bootcamp.board.aggregate.Board;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.board.command.BoardCreate;
import org.bootcamp.board.command.BoardDelete;
import org.bootcamp.board.command.BoardUpdate;
import org.bootcamp.board.query.QueryBoardByBoardType;
import org.bootcamp.board.store.BoardStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    // endpoint Store 분리 why? crud
    private final BoardStore boardStore;

    public BoardService(BoardStore boardStore) {
        //
        this.boardStore = boardStore;
    }

    public String create(BoardCreate command) {
        //
        Board board = new Board(command);
        this.boardStore.create(board);

        return board.getBoardId();
    }

    public void delete(BoardDelete command) {
        //
        this.boardStore.delete(command.getBoardId());
    }

    public void update(BoardUpdate command) {
        //
        Board board = findBoardByBoardId(command.getBoardId());
        board.update(command);
        this.boardStore.update(board);
    }

    //조회를 하면 조회수가 1이 늘어남
    public Board findBoardByBoardId(String boardId) {
        //
        Board board = this.boardStore.query(boardId);
        board.setSequence(board.getSequence()+1);
        this.boardStore.update(board);

        return board;
    }


    public List<Board> findBoardList() {
        //
        return this.boardStore.queryAll();
    }

    public List<Board> findBoardList(QueryBoardByBoardType query) {
        //
        return this.boardStore.query(query.getBoardType());
    }

}
