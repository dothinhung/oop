/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nhung
 */
@WebService(serviceName = "Calculate")
public class Calculate {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Addition")
    public double Addition(@WebParam(name = "number1") double number1, @WebParam(name = "number2") double number2) {
        //TODO write your implementation code here:
        return number1 + number2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Substraction")
    public double Substraction(@WebParam(name = "number1") double number1, @WebParam(name = "number2") double number2) {
        //TODO write your implementation code here:
        return number1 - number2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplication")
    public double multiplication(@WebParam(name = "number1") double number1, @WebParam(name = "number2") double number2) {
        //TODO write your implementation code here:
        return number1 * number2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "divisio")
    public String divisio(@WebParam(name = "number1") double number1, @WebParam(name = "number2") double number2) {
        //TODO write your implementation code here:
        String no3;
        if(number2 !=0){
            double num3 = number1/number2;
            no3 = String.valueOf(num3);
        }else{
            return "Number 2 must be not equal to 0";
        }
        return no3;
    }

}
