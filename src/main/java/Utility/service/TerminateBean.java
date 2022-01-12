package Utility.service;

import javax.annotation.PreDestroy;

public class TerminateBean {
        @PreDestroy
        public void onDestroy(){
            System.out.println("Spring Container is destroyed!");
        }
}
