package cn.com.yusys.yscrm.custservice.util;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.security.NoSuchAlgorithmException;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-13T10:21:26.568+08:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://www.whrcbank.com", name = "CstRsInRgsSvcSrvPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CstRsInRgsSvcSrvPortType {

    @WebMethod(operationName = "CstRsInRgs", action = "urn:CstRsInRgs")
    public void cstRsInRgs(
        @WebParam(partName = "paramCstRsInRgsReqHeader", name = "sysHeader", targetNamespace = "http://www.whrcbank.com/common/header/in", header = true)
        SysMsgHeader paramCstRsInRgsReqHeader,
        @WebParam(partName = "paramCstRsInRgsReqBody", name = "request", targetNamespace = "http://www.whrcbank.com/service/bd/R17602003045R")
        SrvReqBody paramCstRsInRgsReqBody,
        @WebParam(partName = "paramCstRsInRgsResHeader", mode = WebParam.Mode.OUT, name = "sysHeader", targetNamespace = "http://www.whrcbank.com/common/header/in", header = true)
        javax.xml.ws.Holder<SysMsgHeader> paramCstRsInRgsResHeader,
        @WebParam(partName = "paramCstRsInRgsResBody", mode = WebParam.Mode.OUT, name = "response", targetNamespace = "http://www.whrcbank.com/service/bd/R17602003045R")
        javax.xml.ws.Holder<SrvResBody> paramCstRsInRgsResBody
    ) throws NoSuchAlgorithmException;
}
