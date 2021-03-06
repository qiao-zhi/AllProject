
package cn.it.ws.dd;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PhoneService", targetNamespace = "http://dd.ws.it.cn")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PhoneService {


    /**
     * 
     * @param osName
     * @return
     *     returns cn.it.ws.dd.Phone
     */
    @WebMethod
    @WebResult(name = "phone", targetNamespace = "")
    @RequestWrapper(localName = "getMObileInfo", targetNamespace = "http://dd.ws.it.cn", className = "cn.it.ws.dd.GetMObileInfo")
    @ResponseWrapper(localName = "getMObileInfoResponse", targetNamespace = "http://dd.ws.it.cn", className = "cn.it.ws.dd.GetMObileInfoResponse")
    @Action(input = "http://dd.ws.it.cn/PhoneService/getMObileInfoRequest", output = "http://dd.ws.it.cn/PhoneService/getMObileInfoResponse")
    public Phone getMObileInfo(
        @WebParam(name = "osName", targetNamespace = "")
        String osName);

}
