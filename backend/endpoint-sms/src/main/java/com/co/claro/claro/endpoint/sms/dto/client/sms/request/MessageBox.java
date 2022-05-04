
package com.co.claro.claro.endpoint.sms.dto.client.sms.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBox implements Serializable {

	@JsonProperty("messageChannel")
	private String messageChannel;

	@JsonProperty("messageBox")
	private List<MessageBox__1> messageBox = null;

}
