package com.rmon.ci_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {

    @GetMapping("/")
    public String index() {
        return "Index";
    }


    @PostMapping
    public void recieveWebHookNotification(@RequestBody String notification) {
    }


}