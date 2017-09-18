package org.superbiz.moviefun.cachedata;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CacheDataRetriever {

    @Cacheable("wellsFargo")
    public String execute(String arg) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
        }
        return UUID.randomUUID().toString();
    }


}
