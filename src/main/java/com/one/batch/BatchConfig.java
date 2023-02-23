package com.one.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableScheduling
public class BatchConfig {

	@Autowired
	public JobRepository jobRepository;
	
	@Autowired
	public DataSource dataSource;
	
	@Autowired
	public PlatformTransactionManager manager;
	
	
	@Bean
	public Step stepOne() {
		
		return new StepBuilder("stepOne", jobRepository)
				.tasklet(
						(contribution, chunkContext) -> {
							System.out.println("Task one");
							return RepeatStatus.FINISHED;
						}
						, manager
						)
				.build();
		
		
	}
	
	@Bean
	public Job job() {
		return new JobBuilder("job", jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(stepOne())
				.build(); 
	}
	


	
	
}
