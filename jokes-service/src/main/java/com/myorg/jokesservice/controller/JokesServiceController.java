package com.myorg.jokesservice.controller;

import com.myorg.jokesservice.model.ResponseBody;
import com.myorg.jokesservice.service.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokesServiceController {
    @Autowired
    private JokesService jokesService;

    @GetMapping("/api/joke")
    public ResponseBody getJoke() {
        return jokesService.getJoke();
    }
}
