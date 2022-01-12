package Utility.config;

import Utility.service.TerminateBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 @Configuration
 public class ShutdownConfig {

        @Bean
        public TerminateBean getTerminateBean() {
            System.out.println("inside getTerminateBean");
            return new TerminateBean();
        }
 }
