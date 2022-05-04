package com.co.claro.claro.endpoint.sms.dto.client.sms.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseSMS implements Serializable {

	@JsonProperty("headerResponse")
	public HeaderResponseDTO headerResponse;

	@JsonProperty("isValid")
	public String isValid;

	@JsonProperty("message")
	public String message;

}
