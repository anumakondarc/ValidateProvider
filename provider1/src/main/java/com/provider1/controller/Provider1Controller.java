package com.provider1.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class Provider1Controller {

    @GetMapping("/v1/api/account/validate/{accountNumber}")
    public String validateAccountNumber(@PathVariable("accountNumber") Long accountNumber){

        JSONObject retObj = new JSONObject();
        retObj.put("isValid", true);
        System.out.println(retObj.toString());
        return retObj.toString();
    }

}
