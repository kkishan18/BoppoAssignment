package com.kishan.service;

import com.kishan.exceptionhandler.LoginException;
import com.kishan.model.Login;

public interface LoginService {
	
	public String logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
