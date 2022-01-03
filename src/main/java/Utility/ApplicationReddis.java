package Utility;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.*;

import javax.swing.*;
import java.util.Set;

@SpringBootApplication
public class ApplicationReddis {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationReddis.class,args);
    }
}
    //private static final String YOUR_CONNECTION_STRING = "redis://localhost:6379/";


        /*RedisClient redisClient = RedisClient.create(YOUR_CONNECTION_STRING);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> sync = connection.sync();

        sync.set("foo", "bar");

        String result = sync.get("foo");

        connection.close();
        redisClient.shutdown();

        System.out.println(result); // "bar"
    }

        /*Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connected to Redis");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);

        jedis.close();*/

        // Create a Jedis connection pool
        /*JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxIdle(30);
        poolConfig.setMinIdle(10);
        JedisPool jedisPool = new JedisPool(poolConfig,"localhost", 6379,10*1000);
        //jedisPool.close();
        // Get the pool and use the database
        try (Jedis jedis = jedisPool.getResource()) {

            jedis.set("mykey", "Hello from Jedis");
            String value = jedis.get("mykey");
            System.out.println( value );

            jedis.zadd("vehicles", 0, "car");
            jedis.zadd("vehicles", 0, "bike");
            Set<String> vehicles = jedis.zrange("vehicles", 0, -1);
            System.out.println( vehicles );

        }

        // close the connection pool
        jedisPool.close();*/
        /*Config config = new Config();
        // use single Redis server
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //config.useSingleServer().setAddress("127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        // perform operations

        RBucket<String> bucket = redisson.getBucket("simpleObject");
        bucket.set("This is object value");

        RMap<String, String> map = redisson.getMap("simpleMap");
        map.put("mapKey", "This is map value");

        String objectValue = bucket.get();
        System.out.println("stored object value: " + objectValue);

        String mapValue = map.get("mapKey");
        System.out.println("stored map value: " + mapValue);

        redisson.shutdown();*/
