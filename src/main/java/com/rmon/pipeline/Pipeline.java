package com.rmon.pipeline;

import com.rmon.State;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;

public class Pipeline implements Serializable {

    private String name;
    private String agent;
    private State state = State.STOPPED;
    private List<Stage> stages = new ArrayList();

    private static final Logger logger = LogManager.getLogger(Pipeline.class);

    public Pipeline(String name, String agent) {
        setName(name);
        setAgent(agent);
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public void start() {
        state = State.RUNNING;
        logger.info("Starting Pipeline: '{}'", name);
        for (Stage stage : stages) {
            if (!stage.isSkip()) {
                stage.executeStage();
            }
        }
        state = State.STOPPED;
    }

    public void stop() {
        logger.info("Stopping Pipeline: '{}'", name);
        if (state != State.STOPPED) {
            state = State.STOPPED;
            // do stuff
        }
    }

    public void pause() {
        logger.info("Pausing Pipeline: '{}'", name);
        if (state == State.RUNNING) {
            state = State.PAUSED;
            // do stuff
        }
    }

    public void resume() {
        logger.info("Resuming Pipeline: '{}'", name);
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
