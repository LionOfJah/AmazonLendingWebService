package com.icicibank.apimgmt;

import org.springframework.stereotype.Component;

import com.amazon.lending.config.ApiVersion;
import com.amazon.lending.config.LPGConfig;
import com.amazon.lending.config.LPGEndpoint;

@Component
public class ExampleLPGConfig implements LPGConfig {
	@Override
    public LPGEndpoint getEndpoint() {
        return LPGEndpoint.EU_TEST;
    }

    @Override
    public ApiVersion getApiVersion() {
        return ApiVersion.V1_1;
    }
}
