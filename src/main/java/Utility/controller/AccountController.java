package Utility.controller;

import Utility.service.AccountTPSCalc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class AccountController {
    @PostMapping("/accountStatus")
    public ResponseEntity<String> accountTranStatus(@RequestBody String accountNumber){
        System.out.println(accountNumber);
        HttpHeaders headers =new HttpHeaders();
        headers.add("Custom-Header","foo");
        AccountTPSCalc accountTPSCalc = new AccountTPSCalc();
        int returnValue=accountTPSCalc.helperFunction(accountNumber);
        if(returnValue ==0){
            return  new ResponseEntity<>("0",headers,HttpStatus.OK);
            //return new ResponseEntity<>()
        }else{
            return new ResponseEntity<>("1",headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/accountStatusGet")
    public ResponseEntity<String> getAccountTranStatus(){
        HttpHeaders headers =new HttpHeaders();
        headers.add("Custom-Header",  "foo");
        return new ResponseEntity<>("5",headers,HttpStatus.FORBIDDEN);
    }

    @GetMapping("/response-entity")
    public Mono<ResponseEntity<String>> usingResponseEntityBuilder() {
        String responseHeaderKey = "Baeldung-Example-Header";
        String responseHeaderValue = "Value-ResponseEntityBuilder";
        String responseBody = "Response with header using ResponseEntity (builder)";

        return Mono.just(ResponseEntity.ok()
                .header(responseHeaderKey, responseHeaderValue)
                .body(responseBody));
    }

}
