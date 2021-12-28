package com.rmon.ci_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONObject;



@RestController
public class GitHubController {

    @GetMapping("/")
    public String index() {
        return "Index Dude";
    }

    @PostMapping("/hooks")
    public String recieveWebHookNotification(@RequestBody String notification) {
        return("Notification received: " + notification);
    }


}