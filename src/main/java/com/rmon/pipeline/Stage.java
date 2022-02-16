package com.rmon.pipeline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

public class Stage implements Serializable {
    private static final Logger logger = LogManager.getLogger(Stage.class);

    private List<Step> steps = new ArrayList();
    private boolean skip = false;
    private String name;

    public Stage(String name) {
        setName(name);
    }

    public void executeStage() {
        logger.info("Starting Stage: '{}'", name);
        for (Step step : steps) {
            if (!step.isSkip()) {
                step.runCommands();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStep(Step step) {
        steps.add(step);
    }


    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
