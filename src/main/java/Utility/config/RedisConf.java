package Utility.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConf {

    public static RedisClient redisClient;
    public static GenericObjectPool<StatefulRedisConnection<String,String>> pool;

    public static GenericObjectPool<StatefulRedisConnection<String,String>> openRedisConnection() throws Exception{
        redisClient = RedisClient.create(AccountConfiguration.redisConnectionString);
        //if(pool == null){
            pool = ConnectionPoolSupport
                    .createGenericObjectPool(() -> redisClient.connect(), new GenericObjectPoolConfig());
        //}else{
            return pool;
        //}
        //return pool;
    }

    public RedisCommands<String,String> redisCommandFunction() throws Exception{
        StatefulRedisConnection<String, String> connection = pool.borrowObject();
        RedisCommands<String, String> commands = connection.sync();
        commands.multi();
        return commands;
    }

    public void closeRedisConnection(){
        pool.close();
        redisClient.shutdown();
    }

}
