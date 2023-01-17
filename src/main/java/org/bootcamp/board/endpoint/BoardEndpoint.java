package org.bootcamp.board.endpoint;

import org.bootcamp.board.aggregate.Board;
import org.bootcamp.board.aggregate.vo.BoardType;
import org.bootcamp.board.command.BoardCreate;
import org.bootcamp.board.command.BoardDelete;
import org.bootcamp.board.query.QueryBoardByBoardType;
import org.bootcamp.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// crud
@RestController
@RequestMapping("/board")
public class BoardEndpoint {
    //
    private final BoardService boardService;

    public BoardEndpoint(BoardService boardService) {
        //
        this.boardService = boardService;
    }

    // 조회
//    @GetMapping
//
//    // 수정
//    @PutMapping
//
//    // 삭제
//    @DeleteMapping


    //RequestBody
    //Post Put

    @PostMapping
    public String create(@RequestBody BoardCreate command) {
        //
        return this.boardService.create(command);
    }

    //   /1234
    @DeleteMapping("/{boardId}")
    public void delete(@PathVariable String boardId) {
        //
        this.boardService.delete(new BoardDelete(boardId));
    }

    @GetMapping("/{boardId}")
    public Board findBoardByBoardId(@PathVariable String boardId) {
        //
        return this.boardService.findBoardByBoardId(boardId);
    }

    @GetMapping
    public List<Board> findBoardsList() {
        //
        return this.boardService.findBoardList();
    }

    // 왜 @GetMapping("/{boardType}") 안씀?
    // 위에 GetMapping이랑 겹쳐서 그럼 ("/{boardId}/{boardType}") 이렇게 하면 안댐?
    // localhost:8080/board?boardType=Normal
    @GetMapping(value = "", headers = "query=QueryBoardByBoardType")
    public List<Board> findBoardList(@RequestParam BoardType boardType) {
        //
        QueryBoardByBoardType query = new QueryBoardByBoardType(boardType);
        return this.boardService.findBoardList(query);
    }


//    // /{id} ex) /1234 일 때 1234 값을 가져옴
//    @PathVariable
//
//    // 호출 당시 body에 값을 넣어 놓은걸 가져옴
//    @RequestBody
//
//    // ?boardId={boardId}와 같은 url(api주소)이 들어올 경우 boardId 값을 가져옴
//    @RequestParam
//
//    // api 호출당시 header에 넣어 놓은 값을 가져옴
//    @RequestHeader

}
