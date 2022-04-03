package com.rmon.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipelineController {

    @PutMapping("/pipeline")
    public void pipelineCommand(@RequestBody String command) {

    }

}
