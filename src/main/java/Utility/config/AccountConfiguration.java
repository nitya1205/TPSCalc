package Utility.config;

import java.util.HashMap;
import java.util.Map;

public class AccountConfiguration {
    public static final String redisConnectionString="redis://localhost:6379/";
    public static final Long timeToLiveCache = 10L;
    public static final String  ONE = "1";
    public static Map<String,Integer> ACCOUNT_MAX_ALLOWED_TPS_MAP = new HashMap<String, Integer>(){
        {
            put("919916846422",200);
            put("9199168464222",100);

        }
    };
}
