package org.superbiz.moviefun.cachedata;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/cachedata")
public class CacheDataController {

    private static Log logger = LogFactory.getLog(CacheDataController.class);

    private final RedisTemplate template;

    private final CacheDataRetriever cacheDataRetriever;

    public CacheDataController(StringRedisTemplate template, CacheDataRetriever cacheDataRetriever) {
        this.template = template;
        this.cacheDataRetriever = cacheDataRetriever;
        reset();
        operations();
        javaTypes();
    }

    private void reset() {
        this.template.delete(Arrays.asList("abc", "boot", "slow~keys", "data"));
    }

    private void operations() {
        ValueOperations<String, String> ops = this.template.opsForValue();
        Arrays.asList(1, 2, 3, 6).forEach((i) -> ops.increment("abc", i));
        logger.info(ops.get("abc"));
    }

    private void javaTypes() {
        Map<String, String> map = new DefaultRedisMap<>("data", this.template);
        map.put("spring", "boot");
        map = new DefaultRedisMap<>("data", this.template);
        logger.info(map.get("spring"));
    }

    @GetMapping
    public String caching() {
        logger.info("----> 1 " + this.cacheDataRetriever.execute("boot"));
        logger.info("----> 2 " + this.cacheDataRetriever.execute("boot"));
        logger.info("----> 3 " + this.cacheDataRetriever.execute("boot"));

        return  this.cacheDataRetriever.execute("boot");
    }
}
