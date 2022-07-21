package cn.com.yusys.yscrm.cust.person.interfaces;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-27T18:32:31.705+08:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "QryAccountSvcSrvBindingQSService",
                  wsdlLocation = "http://22.1.32.54:8111/services/P00001002360?wsdl",
                  targetNamespace = "http://www.whrcbank.com")
public class QryAccountSvcSrvBindingQSService extends Service {

	
    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.whrcbank.com", "QryAccountSvcSrvBindingQSService");
    public final static QName QryAccountSvcSrvBindingQSPort = new QName("http://www.whrcbank.com", "QryAccountSvcSrvBindingQSPort");
    static {
        URL url = null;
        try {
            url = new URL("http://22.1.32.54:8111/services/P00001002360?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(QryAccountSvcSrvBindingQSService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://22.1.32.54:8111/services/P00001002360?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public QryAccountSvcSrvBindingQSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public QryAccountSvcSrvBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public QryAccountSvcSrvBindingQSService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public QryAccountSvcSrvBindingQSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public QryAccountSvcSrvBindingQSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public QryAccountSvcSrvBindingQSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns QryAccountSvcSrvPortType
     */
    @WebEndpoint(name = "QryAccountSvcSrvBindingQSPort")
    public QryAccountSvcSrvPortType getQryAccountSvcSrvBindingQSPort() {
        return super.getPort(QryAccountSvcSrvBindingQSPort, QryAccountSvcSrvPortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns QryAccountSvcSrvPortType
     */
    @WebEndpoint(name = "QryAccountSvcSrvBindingQSPort")
    public QryAccountSvcSrvPortType getQryAccountSvcSrvBindingQSPort(WebServiceFeature... features) {
        return super.getPort(QryAccountSvcSrvBindingQSPort, QryAccountSvcSrvPortType.class, features);
    }

}