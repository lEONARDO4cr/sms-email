package com.co.claro.claro.endpoint.sms.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.co.claro.claro.endpoint.sms.dto.RequestSftpDTO;
import com.co.claro.claro.endpoint.sms.dto.ResponseDTO;

@Service
public class SFTPClient {

	private static final Logger log = LoggerFactory.getLogger(SFTPClient.class);

	public void sftoCreateFile(String name, String path) {

		RequestSftpDTO request = new RequestSftpDTO();
		request.setNameFile(name);
		request.setPath(path);

		RestTemplate template = new RestTemplate();
		ResponseDTO response = template.postForObject("http://localhost:8081/api/v1/sftp", request, ResponseDTO.class);

		log.info("RequestDTO: {}", request);
		log.info("response: {}", response);

	}

}
