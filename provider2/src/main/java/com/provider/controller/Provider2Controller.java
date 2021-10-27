package com.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Provider2Controller {

    @GetMapping("/v2/api/account/validate/{accountNumber}")
    public String validateAccountNumber(@PathVariable("accountNumber") Long accountNumber){

        JSONObject retObj = new JSONObject();
        retObj.put("isValid", false);
        System.out.println(retObj.toString());
        return retObj.toString();
    }
}
