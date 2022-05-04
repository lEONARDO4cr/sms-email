package com.co.claro.claro.endpoint.sms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@Data
@NoArgsConstructor
public class SmsServiceProperties {

	@Value("${sms.client.header.password:password434}")
	private String password;

	@Value("${sms.client.header.system:system432}")
	private String system;

	@Value("${sms.client.header.target:target}")
	private String target;

	@Value("${sms.client.header.traceability.id:traceabilityId436}")
	private String traceabilityId;

	@Value("${sms.client.header.user:user433}")
	private String user;

	@Value("${sms.client.message.CommunicationOrigin:TCRM}")
	private String communicationOrigin;

	@Value("${sms.client.message.communicationType:COMERCIAL}")
	private String communicationType;

	@Value("${sms.client.message.ContentType:MESSAGE}")
	private String contentType;

	@Value("${sms.client.message.DeliveryReceipts:YES}")
	private String deliveryReceipts;

	@Value("${sms.client.message.messageChannel:SMS}")
	private String messageChannel;

	@Value("${sms.client.message.customerBox:min}")
	private String customerBox;

	@Value("${sms.client.message.profileId:SMS_FS_TCRM1}")
	private String profileId;

	@Value("${sms.client.message.pushType:SINGLE}")
	private String pushType;

	@Value("${sms.client.message.typeCostumer:25987563}")
	private String typeCostumer;

}
