package com.rmon.pipeline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Stage implements Serializable {
    private static final Logger logger = LogManager.getLogger(Stage.class);

    private @Id
    @GeneratedValue
    Long id;
    private List<Step> steps = new ArrayList();
    private boolean skip = false;
    private String name;

    public Stage(String name) {
        setName(name);
    }

    public List<List<String>> executeStage() {
        List<List<String>> output = new ArrayList();
        logger.info("Starting Stage: '{}'", name);
        for (Step step : steps) {
            if (!step.isSkip()) {
                try {
                    output.add(step.runCommands());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return output;
    }


    public Long getId() {
        return id;
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

    public void removeStep(int index) {
        steps.remove(index);
    }

    public List<Step> getSteps() {
        return steps;
    }


    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
