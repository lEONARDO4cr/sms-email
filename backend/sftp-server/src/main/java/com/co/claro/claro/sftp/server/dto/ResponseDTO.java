package com.co.claro.claro.sftp.server.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO implements Serializable {

	private String responseCode;
	private String message;
	private String transactionId;

}
