package com.icicibank.apimgmt;

import org.springframework.stereotype.Component;

import com.amazon.lending.config.AWSConfig;

@Component
public class ExampleAWSConfig implements AWSConfig {
	@Override
    public String getApiKey() {
        return "lTpz02CLEQacACMTVt9Yr3MeIj26Sov74Yo6lezZ";
    }

    @Override
    public String getAwsAccessKey() {
        return "AKIAQJTY763SVSXGNNFJ";
    }

    @Override
    public String getAwsSecretKey() {
        return "r1Lz9s070NNW4QxJBqtdhPV+xlDLuoF8gxPnJFYN";
    }

    @Override
    public String getRoleArn() {
        return "arn:aws:iam::020654847717:role/AmazonLendingAPIRole";
    }

    @Override
    public String getSessionName() {
        return "sts";
    }
}
