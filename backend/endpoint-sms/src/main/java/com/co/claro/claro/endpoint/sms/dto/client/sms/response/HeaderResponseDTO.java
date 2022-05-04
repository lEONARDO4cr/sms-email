package com.co.claro.claro.endpoint.sms.dto.client.sms.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeaderResponseDTO implements Serializable {

	@JsonProperty("responseDate")
	public String responseDate;

	@JsonProperty("traceabilityId")
	public String traceabilityId;

}
