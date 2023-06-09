package de.tramotech.demospringbootbatch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTaskOne implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        System.out.println("MyTaskOne start..");

        Thread.sleep(2000);

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }
}