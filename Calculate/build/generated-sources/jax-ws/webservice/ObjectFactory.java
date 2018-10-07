
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Divisio_QNAME = new QName("http://WebService/", "divisio");
    private final static QName _MultiplicationResponse_QNAME = new QName("http://WebService/", "multiplicationResponse");
    private final static QName _Hello_QNAME = new QName("http://WebService/", "hello");
    private final static QName _Multiplication_QNAME = new QName("http://WebService/", "multiplication");
    private final static QName _DivisioResponse_QNAME = new QName("http://WebService/", "divisioResponse");
    private final static QName _SubstractionResponse_QNAME = new QName("http://WebService/", "SubstractionResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://WebService/", "helloResponse");
    private final static QName _Addition_QNAME = new QName("http://WebService/", "Addition");
    private final static QName _AdditionResponse_QNAME = new QName("http://WebService/", "AdditionResponse");
    private final static QName _Substraction_QNAME = new QName("http://WebService/", "Substraction");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Substraction }
     * 
     */
    public Substraction createSubstraction() {
        return new Substraction();
    }

    /**
     * Create an instance of {@link AdditionResponse }
     * 
     */
    public AdditionResponse createAdditionResponse() {
        return new AdditionResponse();
    }

    /**
     * Create an instance of {@link Addition }
     * 
     */
    public Addition createAddition() {
        return new Addition();
    }

    /**
     * Create an instance of {@link SubstractionResponse }
     * 
     */
    public SubstractionResponse createSubstractionResponse() {
        return new SubstractionResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link DivisioResponse }
     * 
     */
    public DivisioResponse createDivisioResponse() {
        return new DivisioResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Multiplication }
     * 
     */
    public Multiplication createMultiplication() {
        return new Multiplication();
    }

    /**
     * Create an instance of {@link Divisio }
     * 
     */
    public Divisio createDivisio() {
        return new Divisio();
    }

    /**
     * Create an instance of {@link MultiplicationResponse }
     * 
     */
    public MultiplicationResponse createMultiplicationResponse() {
        return new MultiplicationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Divisio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "divisio")
    public JAXBElement<Divisio> createDivisio(Divisio value) {
        return new JAXBElement<Divisio>(_Divisio_QNAME, Divisio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "multiplicationResponse")
    public JAXBElement<MultiplicationResponse> createMultiplicationResponse(MultiplicationResponse value) {
        return new JAXBElement<MultiplicationResponse>(_MultiplicationResponse_QNAME, MultiplicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "multiplication")
    public JAXBElement<Multiplication> createMultiplication(Multiplication value) {
        return new JAXBElement<Multiplication>(_Multiplication_QNAME, Multiplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivisioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "divisioResponse")
    public JAXBElement<DivisioResponse> createDivisioResponse(DivisioResponse value) {
        return new JAXBElement<DivisioResponse>(_DivisioResponse_QNAME, DivisioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubstractionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "SubstractionResponse")
    public JAXBElement<SubstractionResponse> createSubstractionResponse(SubstractionResponse value) {
        return new JAXBElement<SubstractionResponse>(_SubstractionResponse_QNAME, SubstractionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "Addition")
    public JAXBElement<Addition> createAddition(Addition value) {
        return new JAXBElement<Addition>(_Addition_QNAME, Addition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "AdditionResponse")
    public JAXBElement<AdditionResponse> createAdditionResponse(AdditionResponse value) {
        return new JAXBElement<AdditionResponse>(_AdditionResponse_QNAME, AdditionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Substraction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "Substraction")
    public JAXBElement<Substraction> createSubstraction(Substraction value) {
        return new JAXBElement<Substraction>(_Substraction_QNAME, Substraction.class, null, value);
    }

}
