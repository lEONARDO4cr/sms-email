package com.co.claro.claro.endpoint.sms.dto;

import java.io.Serializable;

import com.co.claro.claro.endpoint.sms.enums.DocumentType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDTO implements Serializable {

	@ApiModelProperty(name = "DocumentType", value = "Tipo documento del cliente", example = "CC", required = true)
	private DocumentType documentType;

	@ApiModelProperty(name = "document", value = "Documento del cliente", example = "123456789", required = true)
	private String document;

	@ApiModelProperty(name = "min", value = "Numero de telefono del cliente", example = "322656546", required = true)
	private String min;

	@ApiModelProperty(name = "account", value = "Numero de cuenta del cliente", example = "568542", notes = "Este campo solamente aplica cuando el cliente cuente con el servicio Hogar registrado en mi claro asesor", required = false)
	private String account;

	@ApiModelProperty(name = "mail", value = "Correo del cliente", example = "example@claro.com", required = true)
	private String mail;

	@ApiModelProperty(name = "codAsesor", value = "codigo del asesor", example = "123456", required = true)
	private String codAsesor;

	@ApiModelProperty(name = "nameAsesor", value = "Nombre del asesor", example = "Juan", required = true)
	private String nameAsesor;

}