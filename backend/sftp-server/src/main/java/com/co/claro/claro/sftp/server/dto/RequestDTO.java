package com.co.claro.claro.sftp.server.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDTO implements Serializable {

	@ApiModelProperty(name = "nameFile", value = "nombre del archivo", example = "ENIVO_SMS_20220423", required = true)
	private String nameFile;

	@ApiModelProperty(name = "path", value = "Ruta donde se guardara el archivo", example = "upload", required = true)
	private String path;

}
