package com.validate.provider.model;

public class ValidationResult {

    private boolean isValid = false;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    private String provider;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "isValid=" + isValid +
                "provider=" + provider +
                "}";
    }

}
