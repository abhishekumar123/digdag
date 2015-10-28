package io.digdag.core;

import java.util.Date;
import java.util.TimeZone;

public class CronSchedulerFactory
        implements SchedulerFactory
{
    @Override
    public boolean matches(ConfigSource config)
    {
        return config.has("cron");
    }

    @Override
    public Scheduler newScheduler(ConfigSource config)
    {
        return new CronScheduler(
                config.get("cron", String.class),
                TimeZone.getTimeZone(config.get("timezone", String.class, "UTC")));
    }

    public static class CronScheduler
            extends AbstractCronScheduler
    {
        public CronScheduler(String cronPattern, TimeZone timeZone)
        {
            super(cronPattern, timeZone);
        }
    }
}
