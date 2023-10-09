package com.prajwal.demo.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime timestamsp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime timestamsp, String message, String details) {
		super();
		this.timestamsp = timestamsp;
		this.message = message;
		this.details = details;
	}
	
	public LocalDateTime getTimestamsp() {
		return timestamsp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	

}
