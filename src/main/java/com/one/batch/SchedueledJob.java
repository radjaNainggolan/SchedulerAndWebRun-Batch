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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedueledJob {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	
//	@Scheduled(cron = "0 */1 * * * ?")
//	public void run() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
//		JobParameters params = new JobParametersBuilder()
//		        .addString("JobID", String.valueOf(System.currentTimeMillis()))
//		        .toJobParameters();
//
//		    jobLauncher.run(job, params);
//	}
	
}
