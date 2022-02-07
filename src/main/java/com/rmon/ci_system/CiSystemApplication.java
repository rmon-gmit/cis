package com.rmon.ci_system;

import java.util.Arrays;

import com.rmon.pipeline.Pipeline;
import com.rmon.pipeline.Stage;
import com.rmon.pipeline.Step;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CiSystemApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CiSystemApplication.class, args);

		Step step = new Step();
		step.addCommand("cd \"C:\" && dir");

		Stage stage = new Stage("TestStage");
		stage.addStep(step);

		Pipeline pipeline = new Pipeline("TestPipeline", "docker-agent");
		pipeline.addStage(stage);
		System.out.println("Running main");


		pipeline.start();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}

