package com.hateoas.app.models.errors;

import java.util.Arrays;
import java.util.List;

public class ErrorResponse {
	
	private List<ErrorDetail> errors;
	
	public ErrorResponse(List<ErrorDetail> errors) {
		super();
		this.errors = errors;
	}
	
	public ErrorResponse(ErrorDetail errorDetail) {
		this.errors = Arrays.asList(errorDetail);
	}

	public List<ErrorDetail> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}

}
