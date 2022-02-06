package com.rmon.pipeline;

import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Step implements Serializable {

    private List<String> commands = new ArrayList();

    public Step() {
    }

    public boolean runCommands() {
        for (String command : commands) {
            System.out.printf("Running command: %s\n", command);
        }
        return true;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }


}
