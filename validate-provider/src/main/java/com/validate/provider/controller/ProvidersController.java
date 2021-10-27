package com.validate.provider.controller;


import com.validate.provider.model.ProviderRequest;
import com.validate.provider.model.ProviderValidationResult;
import com.validate.provider.model.ValidationResult;
import com.validate.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ProvidersController {

    @Autowired
    ProviderService providerService;

    @PostMapping("/validateProviders/")
    public ResponseEntity validateProviders(@RequestBody ProviderRequest providerRequest){

        log.info("Provide validation : start");

        ProviderValidationResult returnObj = new ProviderValidationResult();

        if(providerRequest.getAccountNumber() != null){
            List<ValidationResult> result = new ArrayList<ValidationResult>();
            returnObj.setResult(providerService.validateProviders(providerRequest));
            return ResponseEntity.status(HttpStatus.OK). body(returnObj);
        }
        else{
            log.info("Account number is mandatory field");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST). body("Account number can't be null");
        }
    }

}
