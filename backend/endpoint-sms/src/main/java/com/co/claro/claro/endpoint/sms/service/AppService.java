package com.co.claro.claro.endpoint.sms.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.claro.claro.endpoint.sms.client.SFTPClient;
import com.co.claro.claro.endpoint.sms.client.SMSClient;
import com.co.claro.claro.endpoint.sms.dto.RequestDTO;
import com.co.claro.claro.endpoint.sms.dto.ResponseDTO;
import com.co.claro.claro.endpoint.sms.dto.TokenDTO;
import com.co.claro.claro.endpoint.sms.properties.AppProperties;
import com.co.claro.claro.endpoint.sms.util.AESUtil;

import brave.Tracer;

@Service
public class AppService {

	@Autowired
	private Tracer tracer;

	@Autowired
	private AppProperties properties;

	@Autowired
	private SFTPClient client;

	@Autowired
	private SMSClient smsClient;

	private static final Logger log = LoggerFactory.getLogger(AppService.class);

	public ResponseDTO sendMessage(RequestDTO request) {

		ResponseDTO response = new ResponseDTO();
		response.setMessage("Operacion Exitosa");
		String traceId = tracer.currentSpan().context().traceIdString();
		response.setTransactionId(traceId);
		response.setResponseCode("200");

		String encriptToken = request.getToken();

		decriptToken(encriptToken);

		return response;

	}

	public String dateToString(Date date, String format) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

		return simpleDateFormat.format(date);

	}

	public TokenDTO decriptToken(String token) {

		String secretKey = "MICLAROA";
		secretKey = secretKey + dateToString(new Date(), "yyyy-MM-dd");
		try {
			String decript = AESUtil.decrypt(token, secretKey.replaceAll("-", ""));
			log.info(decript);
		} catch (Exception e) {
			log.error("Exception: {}", e.getMessage(), e);
			throw new RuntimeException(e.getMessage());
		}

		return null;
	}

}
