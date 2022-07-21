
package cn.com.yusys.yscrm.info.remind.fileTrans;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.com.yusys.yscrm.salesoppor.fileTrans package. 
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

    private final static QName _SysHeader_QNAME = new QName("http://www.whrcbank.com/common/header/in", "sysHeader");
    private final static QName _Request_QNAME = new QName("http://www.whrcbank.com/service/bd/R14002000312", "request");
    private final static QName _Response_QNAME = new QName("http://www.whrcbank.com/service/bd/R14002000312", "response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.com.yusys.yscrm.salesoppor.fileTrans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SysMsgHeader }
     * 
     */
    public SysMsgHeader createSysMsgHeader() {
        return new SysMsgHeader();
    }

    /**
     * Create an instance of {@link SrvReqBody }
     * 
     */
    public SrvReqBody createSrvReqBody() {
        return new SrvReqBody();
    }

    /**
     * Create an instance of {@link SrvResBody }
     * 
     */
    public SrvResBody createSrvResBody() {
        return new SrvResBody();
    }

    /**
     * Create an instance of {@link SrvReqBizBody }
     * 
     */
    public SrvReqBizBody createSrvReqBizBody() {
        return new SrvReqBizBody();
    }

    /**
     * Create an instance of {@link SrvResBizBody }
     * 
     */
    public SrvResBizBody createSrvResBizBody() {
        return new SrvResBizBody();
    }

    /**
     * Create an instance of {@link SRVReqHead }
     * 
     */
    public SRVReqHead createSRVReqHead() {
        return new SRVReqHead();
    }

    /**
     * Create an instance of {@link SRVResHead }
     * 
     */
    public SRVResHead createSRVResHead() {
        return new SRVResHead();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysMsgHeader }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SysMsgHeader }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.whrcbank.com/common/header/in", name = "sysHeader")
    public JAXBElement<SysMsgHeader> createSysHeader(SysMsgHeader value) {
        return new JAXBElement<SysMsgHeader>(_SysHeader_QNAME, SysMsgHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SrvReqBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SrvReqBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.whrcbank.com/service/bd/R14002000312", name = "request")
    public JAXBElement<SrvReqBody> createRequest(SrvReqBody value) {
        return new JAXBElement<SrvReqBody>(_Request_QNAME, SrvReqBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SrvResBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SrvResBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.whrcbank.com/service/bd/R14002000312", name = "response")
    public JAXBElement<SrvResBody> createResponse(SrvResBody value) {
        return new JAXBElement<SrvResBody>(_Response_QNAME, SrvResBody.class, null, value);
    }

}