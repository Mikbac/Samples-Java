package pl.samples.Quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by MikBac on 19.06.2021
 */

public class SimpleJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String word = dataMap.getString("key-1");
        int number = dataMap.getInt("key-2");
        boolean bool = dataMap.getBoolean("key-3");

        System.out.println("key-1: " + word + ", key-2: " + number + ", key-3: " + bool);
    }
}
