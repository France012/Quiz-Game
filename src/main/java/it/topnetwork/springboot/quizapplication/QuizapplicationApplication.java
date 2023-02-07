package it.topnetwork.springboot.quizapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT10S")
public class QuizapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizapplicationApplication.class, args);
	}

}
