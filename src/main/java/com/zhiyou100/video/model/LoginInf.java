package com.zhiyou100.video.model;

public class LoginInf {
  private String message;
  private String success;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getSuccess() {
	return success;
}
public void setSuccess(String success) {
	this.success = success;
}
@Override
public String toString() {
	return "LoginInf [message=" + message + ", success=" + success + "]";
}
  

}
