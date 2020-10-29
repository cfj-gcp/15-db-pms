package com.cy.db.common.exception;

public class serviceException  extends  RuntimeException{
    private static final long serialVersionUID = 7793296502722655579L;
    public serviceException(){
        super();
    }
    public serviceException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    public serviceException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
