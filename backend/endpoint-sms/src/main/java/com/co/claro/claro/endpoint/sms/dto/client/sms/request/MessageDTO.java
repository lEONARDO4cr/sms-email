
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
public class MessageDTO implements Serializable {

	@JsonProperty("pushType")
	private String pushType;

	@JsonProperty("typeCostumer")
	private String typeCostumer;

	@JsonProperty("messageBox")
	private List<MessageBox> messageBox = null;

	@JsonProperty("profileId")
	private List<String> profileId = null;

	@JsonProperty("communicationType")
	private List<String> communicationType = null;

	@JsonProperty("communicationOrigin")
	private String communicationOrigin;

	@JsonProperty("deliveryReceipts")
	private String deliveryReceipts;

	@JsonProperty("contentType")
	private String contentType;

	@JsonProperty("messageContent")
	private String messageContent;

}
