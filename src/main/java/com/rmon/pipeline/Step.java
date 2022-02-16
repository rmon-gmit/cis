package com.rmon.pipeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

public class Step implements Serializable {

    private static final Logger logger = LogManager.getLogger(Step.class);

    private List<String> commands = new ArrayList();
    private boolean skip = false;

    public Step() {
    }

    public void runCommands() {
        for (String command : commands) {
            try {
                logger.info("Trying command: {}..", command);
                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
