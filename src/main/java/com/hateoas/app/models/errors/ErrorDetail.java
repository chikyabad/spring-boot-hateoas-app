package com.hateoas.app.models.errors;

import org.springframework.http.HttpStatus;

public class ErrorDetail {

	private HttpStatus status;
	private String code;
	private String title;
	private String detail;
	
	public ErrorDetail() {
		super();
	}

	public ErrorDetail(HttpStatus status, String code, String title, String detail) {
		super();
		this.status = status;
		this.code = code;
		this.title = title;
		this.detail = detail;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
