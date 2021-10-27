package com.validate.provider.service;

import com.validate.provider.config.ProvidersConfig;
import com.validate.provider.model.ProviderRequest;
import com.validate.provider.model.Providers;
import com.validate.provider.model.ValidationResult;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class ProviderService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ProvidersConfig providersConfig;

    public List<ValidationResult> validateProviders(ProviderRequest providerRequest){

        List<ValidationResult> result = new ArrayList<ValidationResult>();

        if(providerRequest.getProviders() != null
                && providerRequest.getProviders().size() > 0){

            for(String providerName : providerRequest.getProviders()){
                for(Providers provider : providersConfig.getProviders()){

                    if(provider.getName().equals(providerName)){

                        ValidationResult validationResult = new ValidationResult();
                        validationResult.setProvider(provider.getName());
                        makeProvideValidationCall(provider.getUrl(), providerRequest.getAccountNumber(), validationResult);

                        result.add(validationResult);
                        break;
                    }
                }
            }
        }
        else if(providersConfig != null){
            providersConfig.getProviders().forEach(e -> {
                ValidationResult validationResult = new ValidationResult();
                validationResult.setProvider(e.getName());
                makeProvideValidationCall(e.getUrl(), providerRequest.getAccountNumber(), validationResult);

                result.add(validationResult);
            });

        }

        log.info("Validation results : " + result);
        return result;
    }

    private void makeProvideValidationCall(String providerUrl, Long accountNumber, ValidationResult validationResult){

        try {
            String retVal = restTemplate.getForObject(providerUrl + accountNumber, String.class);
            JSONObject retObj = new JSONObject(retVal);
            validationResult.setValid(retObj.getBoolean("isValid"));
        }catch (Exception e){
            log.error(e.getMessage() + e);
        }
    }

}
