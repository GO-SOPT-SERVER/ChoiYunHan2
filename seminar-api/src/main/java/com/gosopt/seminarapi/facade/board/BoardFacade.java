package com.gosopt.seminarapi.facade.board;

import com.gosopt.seminarapi.presentation.board.request.BoardCreateRequest;
import com.gosopt.seminarapi.presentation.board.response.BoardGetResponse;

public interface BoardFacade {

    void createBoard(BoardCreateRequest request, Long memberId);

    BoardGetResponse getBoard(Long boardId);
}
