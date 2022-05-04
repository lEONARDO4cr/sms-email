package com.co.claro.claro.endpoint.sms.client;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.co.claro.claro.endpoint.sms.dto.client.sms.request.HeaderRequestDTO;
import com.co.claro.claro.endpoint.sms.dto.client.sms.request.MessageBox;
import com.co.claro.claro.endpoint.sms.dto.client.sms.request.MessageBox__1;
import com.co.claro.claro.endpoint.sms.dto.client.sms.request.MessageDTO;
import com.co.claro.claro.endpoint.sms.dto.client.sms.request.RequestSmsDTO;
import com.co.claro.claro.endpoint.sms.dto.client.sms.response.ResponseSMS;
import com.co.claro.claro.endpoint.sms.service.SmsServiceProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SMSClient {

	@Autowired
	private SmsServiceProperties properties;

	private static final Logger log = LoggerFactory.getLogger(SMSClient.class);

	public void sendSMS(String sms, String min, String traceid, String requestDate) {

		HeaderRequestDTO headerRequestDTO = new HeaderRequestDTO();

		headerRequestDTO.setIpApplication("1" + "27.0.0.1");

		headerRequestDTO.setPassword(properties.getPassword());
		headerRequestDTO.setRequestDate(requestDate);
		headerRequestDTO.setSystem(properties.getSystem());
		headerRequestDTO.setTarget(properties.getTarget());
		headerRequestDTO.setTraceabilityId(properties.getTraceabilityId());
		headerRequestDTO.setTransacitonID(traceid);
		headerRequestDTO.setUser(properties.getUser());

		RequestSmsDTO requestSms = new RequestSmsDTO();
		requestSms.setHeaderRequest(headerRequestDTO);

		String message = generateMessageString(sms, min);
		requestSms.setMessage(message);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String requestString = objectMapper.writeValueAsString(requestSms);
			log.info("requestString: {}", requestString);
		} catch (JsonProcessingException e) {
			log.error("JsonProcessingException: {}", e.getMessage(), e);
		}

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<RequestSmsDTO> request = new HttpEntity<>(requestSms);

		ResponseEntity<ResponseSMS> response = restTemplate.exchange(
				"http://100.126.21.189:7777/Notification/V2.0/Rest/PutMessage", HttpMethod.PUT, request,
				ResponseSMS.class);

		log.info("********************response: {}", response);

	}

	private String generateMessageString(String sms, String min) {

		MessageDTO message = new MessageDTO();
		message.setCommunicationOrigin(properties.getCommunicationOrigin());

		List<String> communicationType = new ArrayList<>();
		communicationType.add(properties.getCommunicationType());
		message.setCommunicationType(communicationType);

		message.setContentType(properties.getContentType());
		message.setDeliveryReceipts(properties.getDeliveryReceipts());

		List<MessageBox> messageBoxs = new ArrayList<>();
		MessageBox messageBox = new MessageBox();
		messageBox.setMessageChannel(properties.getMessageChannel());

		List<MessageBox__1> messageBox1 = new ArrayList<>();
		MessageBox__1 box1 = new MessageBox__1();
		box1.setCustomerBox(min);

		messageBox1.add(box1);

		messageBox.setMessageBox(messageBox1);
		messageBoxs.add(messageBox);

		message.setMessageBox(messageBoxs);
		message.setMessageContent(sms);

		List<String> profileIds = new ArrayList<>();
		profileIds.add(properties.getProfileId());
		message.setProfileId(profileIds);

		message.setPushType(properties.getPushType());
		message.setTypeCostumer(properties.getTypeCostumer());

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			String messageString = objectMapper.writeValueAsString(message);
			log.info("messageString: {}", messageString);
			return messageString;

		} catch (JsonProcessingException e) {
			log.error("JsonProcessingException: {}", e.getMessage(), e);
		}

		return null;
	}

}
