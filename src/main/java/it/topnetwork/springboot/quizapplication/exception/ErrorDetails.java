package it.topnetwork.springboot.quizapplication.exception;


public class ErrorDetails {

	private long timestamps;
	private String message;
	private int status;
	
	public ErrorDetails() {
		
	}

	public ErrorDetails(long timestamps, String message, int status) {
	
		this.timestamps = timestamps;
		this.message = message;
		this.status = status;
	}

	public long getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(long timestamps) {
		this.timestamps = timestamps;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
