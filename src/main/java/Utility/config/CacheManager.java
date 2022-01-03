package Utility.config;

import io.lettuce.core.api.sync.RedisCommands;

public interface CacheManager {
    public void storeData(RedisCommands<String,String> commands,String accountNumberInput);
    public int retrieveData(RedisCommands<String,String> commands,String accountNumberInput);
}
