package com.one.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication

public class Batch2Application implements CommandLineRunner{
	
	@Autowired
	JobLauncher jobLauncher;
	   
	@Autowired
	Job job;
	  
	  
	@Scheduled(cron = "* * * ? * *")
	public void run() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters params = new JobParametersBuilder()
		        .addString("JobID", String.valueOf(System.currentTimeMillis()))
		        .toJobParameters();

		    jobLauncher.run(job, params);
	}

	public static void main(String[] args) {
		SpringApplication.run(Batch2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		run();
//		
//		JobParameters params = new JobParametersBuilder()
//		          .addString("JobID", String.valueOf(System.currentTimeMillis()))
//		          .toJobParameters();
//		    jobLauncher.run(job, params);
//		
	}

}
