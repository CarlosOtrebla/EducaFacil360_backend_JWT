package com.otrebla.educa_facil_360.exception;
    
    public class NotValidUserException extends RuntimeException{
        
        public NotValidUserException() { super("Error: The data informed, is not of a valid user."); }
        
        public NotValidUserException(String message){ super(message); }
    }

