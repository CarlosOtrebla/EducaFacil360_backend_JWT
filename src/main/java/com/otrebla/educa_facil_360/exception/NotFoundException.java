package com.otrebla.educa_facil_360.exception;

    public class NotFoundException extends RuntimeException{
        
        public NotFoundException() { super("Error: No entities were found for this request."); }
        
        public NotFoundException(String message) { super(message); }
}
