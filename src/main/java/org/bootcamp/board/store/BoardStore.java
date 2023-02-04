package org.bootcamp.board.store;

import org.bootcamp.board.aggregate.Board;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.board.store.document.BoardDoc;
import org.bootcamp.board.store.document.BoardRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

// back <-> DB의 통로 (소통하기 위한 메서드), crud

@Repository
public class BoardStore {
    //
    private final BoardRepository boardRepository;

    public BoardStore(BoardRepository boardRepository) {
        //
        this.boardRepository = boardRepository;
    }

    public void create(Board board) {
        //
        this.boardRepository.save(new BoardDoc(board));
    }

    public Board query(String boardId) {
        //
        Optional<BoardDoc> doc = this.boardRepository.findById(boardId);

        if (doc.isEmpty()) {
            throw new NoSuchElementException();
        }

        return doc.get().toBoard();
    }

    public List<Board> queryAll() {
        //
        List<BoardDoc> docs = this.boardRepository.findAll();
        return docs.stream().map(BoardDoc::toBoard).collect(Collectors.toList());
    }

    // 조회를 할건데 나는 계시판이 ...인 종류의 계시판들을 조회할 거야
    // 4가지 게시판 일반, 1:1, faq, 건의

    public List<Board> query(BoardType boardType) {
        //
        List<BoardDoc> docs = this.boardRepository.findAllByBoardType(boardType);

        return docs.stream().map(BoardDoc::toBoard).collect(Collectors.toList());
    }

    public void update(Board board) {
        //
        this.boardRepository.save(new BoardDoc(board));
    }

    public void delete(String id) {
        //
        this.boardRepository.deleteById(id);
    }

}
