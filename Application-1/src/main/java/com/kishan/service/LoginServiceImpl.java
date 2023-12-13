package com.kishan.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishan.exceptionhandler.LoginException;
import com.kishan.model.Employee;
import com.kishan.model.Login;
import com.kishan.repository.EmployeeDAO;
import com.mysql.cj.Session;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Override
	public String logIntoAccount(Login dto) throws LoginException {
		// TODO Auto-generated method stub
		 if(dto.getRoll().equalsIgnoreCase("admin"))
		  {
			  Employee emp  = emp.getDeptName(dto.getEmail());
			  
			  if(emp == null)
			  {
				  throw new LoginException("OOps Login failed Pleas try again");
			  }
			  
			  Optional<Session> validCustomerSessionOpt =  ses.findById(emp.getEmpId());
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			     if(emp.getPassword().equals(dto.getPassword()))
			     {
			    	 String key= RandomString.make(6);
			    	 
			    	 Session ss = new Session(emp.getEmpId(), key, LocalDateTime.now());
			    	 
			    	 ses.save(ss);
			    	 return ss.toString();
			     }
			     else
			     {
			    	 throw new LoginException("Please Enter a valid password");
			     }
			  
			      
			  
		  }
		  else
		  {
			  Employee existingCustomer=  epp.findByemail(dto.getEmail());
			  
			  
			  if(existingCustomer == null) {
					
					throw new LoginException("Please Enter a valid email  and password");
					
					 
				}
			  
			  
			  Optional<Session> validCustomerSessionOpt =  ses.findById(existingCustomer.getName());
			  
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			  if(existingEmployee.getPassword().equals(dto.getPassword())) {
					
					String key= RandomString.make(6);
					
					
					
					Session currentUserSession = new Session(existingCustomer.getEmployeeId(),key,LocalDateTime.now());
					
					ses.save(currentUserSession);

					return currentUserSession.toString();
				}
			  else
			  {
				  throw new LoginException("Pleas enter the valid email or password");
			  }
			  
		  }
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
				Session validCustomerSession = ses.findByuuid(key);
				if(validCustomerSession == null) {
					throw new LoginException("User Not Logged In with this number");
					
				}
		ses.delete(validCustomerSession);
				
				
				return "Logged Out !";
			}

}
