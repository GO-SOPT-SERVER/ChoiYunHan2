package com.gosopt.seminarapi.presentation.board;

import com.gosopt.seminarapi.facade.board.BoardFacade;
import com.gosopt.seminarapi.presentation.board.request.BoardCreateRequest;
import com.gosopt.seminarapi.presentation.board.response.BoardGetResponse;
import com.gosopt.seminardomain.global.common.resolver.UserId;
import com.gosopt.seminardomain.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardFacade boardFacade;

    @PostMapping
    public ApiResponse createBoard(
            @RequestBody BoardCreateRequest request,
            @UserId Long memberId
            ) {
        boardFacade.createBoard(request, memberId);
        return ApiResponse.success(HttpStatus.CREATED, "게시글 생성 성공");
    }

    @GetMapping("/{boardId}")
    public ApiResponse<BoardGetResponse> getBoard(@PathVariable("boardId") Long boardId) {
        return ApiResponse.success(HttpStatus.OK, "게시글 조회 성공", boardFacade.getBoard(boardId));
    }
}
