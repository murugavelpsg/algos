package com.muru.problems.general.datastream;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.

 Example:

 Logger logger = new Logger();

 // logging string "foo" at timestamp 1
 logger.shouldPrintMessage(1, "foo"); returns true;

 // logging string "foo" at timestamp 3
 logger.shouldPrintMessage(3,"foo"); returns false;

 // logging string "foo" at timestamp 11
 logger.shouldPrintMessage(11,"foo"); returns true;
 * Created by msivagna on 12/20/16.
 */
public class LogRateLimiter {
    Map<String, Long> rateLimiterMap = new HashMap<String, Long>();

    public boolean shouldPrintMessage(String message, long timeStamp) {
        if (rateLimiterMap.get(message) != null && (timeStamp - rateLimiterMap.get(message)) < 10000L) {
            return false;
        }
        rateLimiterMap.put(message, timeStamp);
        return true;
    }
}
