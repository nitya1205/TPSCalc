package Utility.service;

import Utility.config.AccountConfiguration;
import Utility.config.CacheManager;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements CacheManager {
    @Override
    public void storeData(RedisCommands<String, String> sync, String accountNumberInput) {
        sync.incr(accountNumberInput);
    }

    @Override
    public int retrieveData(RedisCommands<String, String> sync, String accountNumberInput) {
        String receivedValue= (String) sync.get(accountNumberInput);
        if(receivedValue!=null){
            return Integer.parseInt(sync.get(accountNumberInput));
        }
        return -1;
    }
    public void storeFirstIncrementCurrentTPS(RedisCommands<String, String> sync, String accountNumberInput) {
        sync.setex(accountNumberInput, AccountConfiguration.timeToLiveCache,AccountConfiguration.ONE);
    }

}
