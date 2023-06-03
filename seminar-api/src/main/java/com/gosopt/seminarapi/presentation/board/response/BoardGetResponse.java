package com.gosopt.seminarapi.presentation.board.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class BoardGetResponse {

    private String title;
    private String content;
}
