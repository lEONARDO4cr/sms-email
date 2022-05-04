package com.co.claro.claro.endpoint.sms.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDTO implements Serializable {

	@ApiModelProperty(name = "token", value = "Recibo del token", example = "RPpA0Bf3BZmKOVQV6D1y4Y0t59qA33Ty/28Dkr14L3gxLVIRDjksl7e4Fy8ddiPbf38k8Av9KKMgk0onbcMf3Q==", required = true)
	private String token;

}