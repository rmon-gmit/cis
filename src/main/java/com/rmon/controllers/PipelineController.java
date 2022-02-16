package com.rmon.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipelineController {

    @PostMapping("/pipeline")
    public void pipelineCommand(@RequestBody String command) {

    }

}
