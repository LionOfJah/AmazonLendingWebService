package com.icicibank.apimgmt;

import org.springframework.stereotype.Component;

import com.amazon.lending.config.SecurityConfig;
import com.amazon.lending.security.SecurityKeyProvider;
import com.amazon.lending.security.impl.FileSecurityKeyProvider;

@Component
public class ExampleSecurityConfig implements SecurityConfig {
	@Override
    public SecurityKeyProvider getAmazonPublicKeyProvider() {
        // Note that Amazon Lending strongly encourages the use of secure key storage practices.
        // A file-based provider is included as an example; see com.amazon.lending.security.SecurityKeyProvider
        return new FileSecurityKeyProvider("/u0/apache-tomcat-8.5.14/amazon/amazon_public.pem");
    }

    @Override
    public String getDefaultAmazonKeyId() {
        return "9koXwGCqbbOMRrmoUSKKPjaRGtM=";
    }

    @Override
    public SecurityKeyProvider getPrivateKeyProvider() {
        // Note that Amazon Lending strongly encourages the use of secure key storage practices.
        // A file-based provider is included as an example; see com.amazon.lending.security.SecurityKeyProvider
        return new FileSecurityKeyProvider("/u0/apache-tomcat-8.5.14/amazon/icici_private.pem");
    }

    @Override
    public String getDefaultPrivateKeyId() {
    	return "29663bcaff9c5ebc708cccfae784e104";
    }
}