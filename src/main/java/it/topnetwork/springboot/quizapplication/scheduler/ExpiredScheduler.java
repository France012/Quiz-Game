package it.topnetwork.springboot.quizapplication.scheduler;





import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Component
@EnableScheduling
public class ExpiredScheduler {
	
	private final static Logger logger = LoggerFactory.getLogger(ExpiredScheduler.class);

	@Scheduled(cron = "0/10 * * * * ?")
	@SchedulerLock(
	            name = "UNIQUE_KEY_FOR_SHEDLOCK_SCHEDULER",
	            lockAtLeastFor = "PT5S", // lock for at least a minute, overriding defaults
	            lockAtMostFor = "PT10S" // lock for at most 7 minutes
	    )
	public void schedulerTest() {
		LockAssert.assertLocked();
		logger.info("Questo Messaggio viene mandato ogni 10 secondi: " + LocalDateTime.now());
		
		
	}
	
}
