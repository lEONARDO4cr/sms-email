package com.co.claro.claro.endpoint.sms.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestSftpDTO implements Serializable {

	private String nameFile;

	private String path;

}
