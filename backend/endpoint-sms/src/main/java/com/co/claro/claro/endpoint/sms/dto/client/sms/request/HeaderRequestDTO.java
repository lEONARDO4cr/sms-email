package com.co.claro.claro.endpoint.sms.dto.client.sms.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderRequestDTO implements Serializable {

	private String transacitonID;

	private String system;

	private String target;

	private String user;

	private String password;

	private String requestDate;

	private String ipApplication;

	private String traceabilityId;

}