package com.aspire.usermanagement.service.dto;

import java.time.LocalDateTime;

public class CommonResponseDTO <T>{
	private int status;
	private T data;
	private String message;
	private LocalDateTime timeStamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timestamp) {
		this.timeStamp = timestamp;
	}
}
	
		
		

