package com.cy.db.common.until;
import com.cy.db.common.exception.serviceException;
public class ValidUitls {
    public static void isArgsValid(boolean statement,String msg){
        if(statement) throw  new  IllegalArgumentException(msg);
    }
    public static void isResultValid(boolean statement,String msg){
        if(statement) throw  new serviceException(msg);
    }
}
