package com.generation.es2springdatabase.mvccontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyErrorCtrlMvc implements ErrorController  {
	//Versione 1
	//non serve il controller,
	//basta aggiungere ad "application.properties"
	//server.error.whitelabel.enabled=false
	//e creare una pagina "error.html" che viene trovata automaticamente

//	//@Controller MVC
//	//Versione 2
//    @RequestMapping("/error")
//    public String handleError() {
//        //do something like logging
//        return "error";
//    }
    
    //@Controller MVC
    //Versione 3: con "Status Code" errore    
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
        
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "/errori/error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "/errori/error-500";
            }
        }
        return "error";
    }
    
}
