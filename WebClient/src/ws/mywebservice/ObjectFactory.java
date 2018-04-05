
package ws.mywebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.mywebservice package. 
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

    private final static QName _GetPhoneInfo_QNAME = new QName("http://myWebService.ws/", "getPhoneInfo");
    private final static QName _GetPhoneInfoResponse_QNAME = new QName("http://myWebService.ws/", "getPhoneInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.mywebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPhoneInfoResponse }
     * 
     */
    public GetPhoneInfoResponse createGetPhoneInfoResponse() {
        return new GetPhoneInfoResponse();
    }

    /**
     * Create an instance of {@link GetPhoneInfo }
     * 
     */
    public GetPhoneInfo createGetPhoneInfo() {
        return new GetPhoneInfo();
    }

    /**
     * Create an instance of {@link Phone }
     * 
     */
    public Phone createPhone() {
        return new Phone();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhoneInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myWebService.ws/", name = "getPhoneInfo")
    public JAXBElement<GetPhoneInfo> createGetPhoneInfo(GetPhoneInfo value) {
        return new JAXBElement<GetPhoneInfo>(_GetPhoneInfo_QNAME, GetPhoneInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhoneInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myWebService.ws/", name = "getPhoneInfoResponse")
    public JAXBElement<GetPhoneInfoResponse> createGetPhoneInfoResponse(GetPhoneInfoResponse value) {
        return new JAXBElement<GetPhoneInfoResponse>(_GetPhoneInfoResponse_QNAME, GetPhoneInfoResponse.class, null, value);
    }

}
