package pl.samples.Quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by MikBac on 19.06.2021
 */

public class Main {

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        JobDetail job = getJob();
        Trigger trigger = getTriggers();

        scheduler.scheduleJob(job, trigger);
    }

    private static Scheduler getScheduler() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return scheduler;
    }

    private static JobDetail getJob() {
        return JobBuilder.newJob(SimpleJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("key-1", "aaa")
                .usingJobData("key-2", 123)
                .usingJobData("key-3", true)
                .build();
    }

    private static Trigger getTriggers() {
        return TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();
    }

}
