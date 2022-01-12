package Utility.config;

import io.lettuce.core.api.sync.RedisCommands;

public interface CacheManager {
    void storeData(RedisCommands<String, String> commands, String accountNumberInput);
    int retrieveData(RedisCommands<String, String> commands, String accountNumberInput);
}
