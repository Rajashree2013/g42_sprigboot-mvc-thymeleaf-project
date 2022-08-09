package se.lexicon.mvcthymeleaf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView illegalArgumentException(IllegalArgumentException ex){
        System.out.println("--------------------");
        Error customError= new Error("400", "Argument Exception");
        return new ModelAndView("custom-error", "error", customError);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception ex){
        return new ModelAndView("error", "error", "INTERNAL ERROR");

    }
}
