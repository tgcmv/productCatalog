package br.com.compasso.productCatalog.config.validation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDTO {
	private Integer status_code;
	private String message;
}
