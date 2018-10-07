
package webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculator", targetNamespace = "http://WebServices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculator {


    /**
     * 
     * @param no2
     * @param no1
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "multiplication", targetNamespace = "http://WebServices/", className = "webservices.Multiplication")
    @ResponseWrapper(localName = "multiplicationResponse", targetNamespace = "http://WebServices/", className = "webservices.MultiplicationResponse")
    @Action(input = "http://WebServices/Calculator/multiplicationRequest", output = "http://WebServices/Calculator/multiplicationResponse")
    public double multiplication(
        @WebParam(name = "no1", targetNamespace = "")
        double no1,
        @WebParam(name = "no2", targetNamespace = "")
        double no2);

    /**
     * 
     * @param no2
     * @param no1
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "substraction", targetNamespace = "http://WebServices/", className = "webservices.Substraction")
    @ResponseWrapper(localName = "substractionResponse", targetNamespace = "http://WebServices/", className = "webservices.SubstractionResponse")
    @Action(input = "http://WebServices/Calculator/substractionRequest", output = "http://WebServices/Calculator/substractionResponse")
    public double substraction(
        @WebParam(name = "no1", targetNamespace = "")
        double no1,
        @WebParam(name = "no2", targetNamespace = "")
        double no2);

    /**
     * 
     * @param no2
     * @param no1
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "division", targetNamespace = "http://WebServices/", className = "webservices.Division")
    @ResponseWrapper(localName = "divisionResponse", targetNamespace = "http://WebServices/", className = "webservices.DivisionResponse")
    @Action(input = "http://WebServices/Calculator/divisionRequest", output = "http://WebServices/Calculator/divisionResponse")
    public String division(
        @WebParam(name = "no1", targetNamespace = "")
        double no1,
        @WebParam(name = "no2", targetNamespace = "")
        double no2);

    /**
     * 
     * @param no2
     * @param no1
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addition", targetNamespace = "http://WebServices/", className = "webservices.Addition")
    @ResponseWrapper(localName = "additionResponse", targetNamespace = "http://WebServices/", className = "webservices.AdditionResponse")
    @Action(input = "http://WebServices/Calculator/additionRequest", output = "http://WebServices/Calculator/additionResponse")
    public double addition(
        @WebParam(name = "no1", targetNamespace = "")
        double no1,
        @WebParam(name = "no2", targetNamespace = "")
        double no2);

}