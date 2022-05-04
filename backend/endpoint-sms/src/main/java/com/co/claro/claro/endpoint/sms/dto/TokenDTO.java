package com.co.claro.claro.endpoint.sms.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO implements Serializable {

	private List<String> phones;

	private String name;

}
