/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nhung
 */
@WebService(serviceName = "Calculator")
public class Calculator {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addition")
    public double addition(@WebParam(name = "no1") double no1, @WebParam(name = "no2") double no2) {
        //TODO write your implementation code here:
        return no1 + no2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "substraction")
    public double substraction(@WebParam(name = "no1") double no1, @WebParam(name = "no2") double no2) {
        //TODO write your implementation code here:
        return no1 - no2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplication")
    public double multiplication(@WebParam(name = "no1") double no1, @WebParam(name = "no2") double no2) {
        //TODO write your implementation code here:
        return no1 * no2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "division")
    public String division(@WebParam(name = "no1") double no1, @WebParam(name = "no2") double no2) {
        //TODO write your implementation code here:
        String no3;
        if(no2 !=0){
            double num3 = no1/no2;
            no3 = String.valueOf(num3);
        }else{
            return "Number 2 must be not equal to 0";
        }
        return no3;
    }
}
