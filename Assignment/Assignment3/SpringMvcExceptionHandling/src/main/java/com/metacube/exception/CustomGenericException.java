package com.metacube.exception;

import org.apache.log4j.Logger;

public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger
			.getLogger(CustomGenericException.class);

	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		log.info(errCode + " Caused By " + errMsg);
	}

}