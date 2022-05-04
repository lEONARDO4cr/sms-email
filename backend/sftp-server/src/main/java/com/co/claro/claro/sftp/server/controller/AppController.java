package com.co.claro.claro.sftp.server.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.claro.claro.sftp.server.dto.RequestDTO;
import com.co.claro.claro.sftp.server.dto.ResponseDTO;
import com.co.claro.claro.sftp.server.service.CSVService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "sftp")
public class AppController {

	private static final Logger log = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private CSVService csvService;

	@PostMapping("/sftp")
	@ApiOperation(value = "Virtualiza conexion con servidor sftp", response = ResponseDTO.class, produces = "application/json; charset=UTF-8")
	public ResponseDTO sms(@RequestBody RequestDTO request) throws IOException {

		log.info("request: {}", request);

		String localPath = "C:/Users/PROFESSIONAL/OneDrive/Escritorio/upload";

		csvService.createfile("/GOSTURA/TEST/", localPath, "ENIVO_SMS_20220423");

		return null;
	}
}
