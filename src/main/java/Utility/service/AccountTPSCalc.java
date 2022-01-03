package Utility.service;

import Utility.config.AccountConfiguration;
import Utility.config.RedisConf;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class AccountTPSCalc {
    public int helperFunction(String accountNumberInput) {
    RedisService redisService =new RedisService();

    try{
        GenericObjectPool<StatefulRedisConnection<String, String>> pool= RedisConf.openRedisConnection();
        StatefulRedisConnection<String, String> connection = pool.borrowObject();
        RedisCommands<String, String> commands = connection.sync();
        commands.multi();
        int existingTPSValue = redisService.retrieveData(commands,accountNumberInput);
        if(existingTPSValue <0){
            redisService.retrieveData(commands,accountNumberInput);
        }else{
            redisService.storeData(commands,accountNumberInput);
        }
        return statusReturnCalc(accountNumberInput,existingTPSValue);
    } catch (Exception e) {
        e.printStackTrace();
    }
        return 1;
    }

    private int statusReturnCalc(String accountNumberInput, int existingTPSValue) {
        int thresholdTPS = AccountConfiguration.ACCOUNT_MAX_ALLOWED_TPS_MAP.getOrDefault(accountNumberInput,0);
        if(thresholdTPS >0 && existingTPSValue >-2) {
            if (thresholdTPS > existingTPSValue) {
                System.out.println("Transaction Allowed");
                return 0;
            } else {
                System.out.println("Transaction Failed");
                return 1;
            }
        }else{
            System.out.println("Either account doesnot exists in list");
            return 2;
        }
    }
}
