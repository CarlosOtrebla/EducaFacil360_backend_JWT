package com.otrebla.educa_facil_360.exception;



public class RequestParamRequired extends RuntimeException{
    
    public RequestParamRequired() { super("Error: Request param is required to send requests to this route."); }
    
    public RequestParamRequired(String message) { super(message); }
}
