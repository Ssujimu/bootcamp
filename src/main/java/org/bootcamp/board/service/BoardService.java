package org.bootcamp.board.service;

import org.bootcamp.board.aggregate.Board;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.board.command.BoardCreate;
import org.bootcamp.board.command.BoardDelete;
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

    public Board findBoardByBoardId(String boardId) {
        //
        return this.boardStore.query(boardId);
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
