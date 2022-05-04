package com.co.claro.claro.endpoint.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.claro.claro.endpoint.sms.dto.RequestDTO;
import com.co.claro.claro.endpoint.sms.dto.ResponseDTO;
import com.co.claro.claro.endpoint.sms.service.AppService;
import com.co.claro.claro.endpoint.sms.util.AESUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "SMS")
public class SMSController {

	@Autowired
	private AppService service;

	private static final Logger log = LoggerFactory.getLogger(SMSController.class);

	@PostMapping("/sms")
	@ApiOperation(value = "Virtualiza el envio de un sms", response = ResponseDTO.class, produces = "application/json; charset=UTF-8")
	public ResponseDTO sms(@RequestBody RequestDTO request) {

		log.info("request: {}", request);

		return service.sendMessage(request);

	}

	@PostMapping("/decript")
	public String decryptToken(@RequestHeader("token") String token, @RequestHeader("secretKey") String secretKey)
			throws Exception {

		return AESUtil.decrypt(token, secretKey);

	}

}
