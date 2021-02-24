package com.icicibank.apimgmt.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazon.lending.client.LendingPartnerGatewayClient;
import com.amazon.lending.client.impl.DefaultLendingPartnerGatewayClient;
import com.amazon.lending.http.exception.LPGRequestException;
import com.amazon.lending.model.Application;
import com.amazon.lending.model.Offer;
import com.icicibank.apimgmt.ExampleAWSConfig;
import com.icicibank.apimgmt.ExampleLPGConfig;
import com.icicibank.apimgmt.ExampleSecurityConfig;

@Controller
public class AmazonLendingController {
	
	final LendingPartnerGatewayClient client = new DefaultLendingPartnerGatewayClient();
	
	public AmazonLendingController() {
		try {
			client.initialize(new ExampleSecurityConfig(), new ExampleAWSConfig(), new ExampleLPGConfig());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseBody
	public String home() {
		return "Spring boot is working!";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOffer")
	@ResponseBody
	public Offer getOffer(@RequestParam String offerId) throws LPGRequestException, IOException {
		return client.getOffer(offerId);
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/createOffer")
//	@ResponseBody
//	public Offer createOffer(@RequestBody Offer offer) throws LPGRequestException, IOException {
//		return client.createOffer(offer);
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/inquireOffer")
	@ResponseBody
	public Offer inquireOffer(@RequestParam String offerId) throws LPGRequestException, IOException {
		return client.inquireOffer(offerId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getApplication")
	@ResponseBody
	public Application getApplication(@RequestParam String applicationId) throws LPGRequestException, IOException {
		return client.getApplication(applicationId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createApplication")
	@ResponseBody
	public Application createApplication(@RequestBody Application application) throws LPGRequestException, IOException {
		return client.createApplication(application);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateApplication")
	@ResponseBody
	public Application updateApplication(@RequestBody Application application) throws LPGRequestException, IOException {
		return client.updateApplication(application);
	}
	
}
