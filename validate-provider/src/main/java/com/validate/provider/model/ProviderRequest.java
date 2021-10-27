package com.validate.provider.model;

import org.springframework.lang.NonNull;

import java.util.List;

public class ProviderRequest {

    @NonNull
    Long accountNumber;
    List<String> providers;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "ProviderRequest{" +
                "accountNumber=" + accountNumber +
                ", providers=" + providers +
                "}";
    }
}
