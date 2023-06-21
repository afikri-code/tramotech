package de.tramotech.demospringbootbatch.config;

import de.tramotech.demospringbootbatch.tasks.MyTaskOne;
import de.tramotech.demospringbootbatch.tasks.MyTaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.builder.TaskletStepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilder jobs;

    @Autowired
    private StepBuilder steps;

    @Bean
    public Step stepOne(){
        StepBuilder a = new StepBuilder("stepOne");
        TaskletStepBuilder b = a.tasklet(new MyTaskOne());
        TaskletStep c = b.build();

        return c;
    }

    @Bean
    public Step stepTwo(){
        StepBuilder a = new StepBuilder("stepTwo");
        TaskletStepBuilder b = a.tasklet(new MyTaskOne());
        TaskletStep c = b.build();
        return c;
    }

    @Bean
    public Job demoJob(){

        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }


}
