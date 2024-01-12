package org.example.design;

import java.sql.Timestamp;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter2 {

    //TODO - ideally pull from a config file
    private static Integer MAX_REQUESTS_PER_SECOND = 100;
    private static Integer TIME_INTERVAL_MS = 1000;
    ConcurrentHashMap<Integer, Queue<Timestamp>> clientIdToRequestsQueue;

    public RateLimiter2() {
        clientIdToRequestsQueue = new ConcurrentHashMap<>();

    }

    public boolean isAllowed(Integer clientId) {
        Queue<Timestamp> queue = clientIdToRequestsQueue.get(clientId);

        //first, add this request to queue
        Timestamp now = new Timestamp(System.currentTimeMillis());
        queue.add(now);

        //check timestamp of head of queue
        Timestamp head = null;
        if (queue.size() < MAX_REQUESTS_PER_SECOND) {
            //within less than 100 requests- isAllowed true
            return true;
        }
        else{
            head = queue.poll();
        }

        long diff = now.getTime() - head.getTime();
        //within 1000 ms, over 100 calls were made
        if (diff < TIME_INTERVAL_MS) {
            return false;
        }
        return true;
    }

}
