package org.example.design;

import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*/
Implement a RateLimiter Class with an isAllow method.
Every request comes in with a unique clientID,
deny a request if that client has made more than 100 requests in the past second.
 */
public class RateLimiter {

    //TODO - Put this in memcache/redis for refrence by multiple nodes instead
    private HashMap<Integer, Integer> clientIdToRequestCount = new HashMap<>();;

    //TODO- Read this from a config file instead
    private static int MAX_REQUESTS_PER_USER = 100;
    private static int CACHE_CLEAR_TIME = 60;

    public RateLimiter(){
        clientIdToRequestCount = new HashMap<>();

        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                clientIdToRequestCount.clear();
            }
        }, 0, 60, TimeUnit.SECONDS); // execute every 60 seconds
    }


    public boolean isAllow(Integer clientId){
        Integer count = clientIdToRequestCount.get(clientId);
        if(count >= 20){
            //throttle
            return false;
        }
        clientIdToRequestCount.put(clientId, count+1);
        return true;
    }

}
