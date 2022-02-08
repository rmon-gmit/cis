package com.rmon.pipeline;

import com.rmon.State;
import org.apache.commons.logging.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Pipeline implements Serializable {

    private String name;
    private String agent;
    private State state = State.STOPPED;
    private List<Stage> stages = new ArrayList();

    public Pipeline(String name, String agent) {
        setName(name);
        setAgent(agent);
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public void start() {
        state = State.RUNNING;
        for (Stage stage : stages) {
            if (!stage.isSkip()) {
                stage.executeStage();
            }
        }
        state = State.STOPPED;
    }

    public void stop() {
        if (state != State.STOPPED) {
            state = State.STOPPED;
            // do stuff
        }
    }

    public void pause() {
        if (state == State.RUNNING) {
            state = State.PAUSED;
            // do stuff
        }
    }

    public void resume() {
        if (state == State.PAUSED) {
            state = State.RUNNING;
            // do stuff
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
