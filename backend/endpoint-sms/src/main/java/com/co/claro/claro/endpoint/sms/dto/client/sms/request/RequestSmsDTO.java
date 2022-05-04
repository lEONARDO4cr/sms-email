package com.co.claro.claro.endpoint.sms.dto.client.sms.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestSmsDTO implements Serializable {

	private HeaderRequestDTO headerRequest;

	private String message;

}
