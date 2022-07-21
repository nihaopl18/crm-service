package cn.com.yusys.yscrm.cust.person.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-27T18:32:31.698+08:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://www.whrcbank.com", name = "QryAccountSvcSrvPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface QryAccountSvcSrvPortType {

    @WebMethod(operationName = "QryAccount", action = "urn:QryAccount")
    public void qryAccount(
        @WebParam(partName = "paramQryAccountReqHeader", name = "sysHeader", targetNamespace = "http://www.whrcbank.com/common/header/in", header = true)
        SysMsgHeader paramQryAccountReqHeader,
        @WebParam(partName = "paramQryAccountReqBody", name = "request", targetNamespace = "http://www.whrcbank.com/service/bd/R11001002357")
        SrvReqBody paramQryAccountReqBody,
        @WebParam(partName = "paramQryAccountResHeader", mode = WebParam.Mode.OUT, name = "sysHeader", targetNamespace = "http://www.whrcbank.com/common/header/in", header = true)
        javax.xml.ws.Holder<SysMsgHeader> paramQryAccountResHeader,
        @WebParam(partName = "paramQryAccountResBody", mode = WebParam.Mode.OUT, name = "response", targetNamespace = "http://www.whrcbank.com/service/bd/R11001002357")
        javax.xml.ws.Holder<SrvResBody> paramQryAccountResBody
    );
}
