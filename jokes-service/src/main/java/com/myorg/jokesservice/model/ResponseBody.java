package com.myorg.jokesservice.model;

import lombok.Data;

@Data
public class ResponseBody {

    private String responseMessage;
    private JokeBody response;
}
