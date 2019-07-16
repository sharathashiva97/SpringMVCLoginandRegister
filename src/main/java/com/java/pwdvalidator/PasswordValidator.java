package com.java.pwdvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java.model.User;

 
 
public class PasswordValidator implements Validator {
 
	
    public boolean supports(Class<?> paramClass) {
    	System.out.println("valid");
        return User.class.equals(paramClass);
    
    }
    
 
    public void validate(Object obj, Errors errors) {
    	System.out.println("valid");
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username1", "valid.username");
    	 User user= (User) obj;
    	 //Parts parts=(Parts)obj;
    	 //System.out.println(user.getUsername().length());
    	 
    	 if(!(user.getUsername().length()<20))
         {
         	errors.rejectValue("username1", "valid.usernamelength");
         }
    	 if(user.getPassword().length()<8 )
    	 {
    		 errors.rejectValue("password1", "valid.passwordlength");
    		 
    	 }
    	 
    	 if(user.getPassword().length()>12 )
    	 {
    		 errors.rejectValue("password1", "valid.passwordlength1");
    		 
    	 }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password1", "valid.password");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf", "valid.passwordConf");
       
       /* if (!user.getPassword().equals(user.getPasswordConf())) {
            errors.rejectValue("passwordConf", "valid.passwordConfDiff");
        }*/
       
    }
}
