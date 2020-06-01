package com.demo.librarymanagement.library_management_system.exception;

import java.util.Map;

public class ErrorMessageResponse {
    private String status;
    private Map<String, String> message;
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorMessageResponse() {
        super();
    }

    public ErrorMessageResponse(String status, Map<String, String> message, String errorCode) {
        //this.tiemstamp = tiemstamp;
        this.status = status;
        this.message = message;
        this.errorCode=errorCode;
    }

	/*public Date getTiemstamp() {
		return tiemstamp;
	}

	public void setTiemstamp(Date tiemstamp) {
		this.tiemstamp = tiemstamp;
	}*/

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
