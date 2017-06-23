package com.choa.util;

import org.springframework.web.multipart.MultipartFile;

public class SeDTO {
	private String callback;
	private String callback_func;
	private MultipartFile Filedata; //3개의 필드 전부 se 로 오는 파라미터와 파일이름
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public String getCallback_func() {
		return callback_func;
	}
	public void setCallback_func(String callback_func) {
		this.callback_func = callback_func;
	}
	public MultipartFile getFiledata() {
		return Filedata;
	}
	public void setFiledata(MultipartFile filedata) {
		Filedata = filedata;
	}

}
