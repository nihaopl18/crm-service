package cn.com.yusys.yscrm.salesoppor.fileTrans;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-16T10:12:21.813+08:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "RealtimeTransJobSrvSrvBindingQSService",
                  wsdlLocation = "http://22.1.32.54:8111/services/P00002000313?wsdl",
                  targetNamespace = "http://www.whrcbank.com")
public class RealtimeTransJobSrvSrvBindingQSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.whrcbank.com", "RealtimeTransJobSrvSrvBindingQSService");
    public final static QName RealtimeTransJobSrvSrvBindingQSPort = new QName("http://www.whrcbank.com", "RealtimeTransJobSrvSrvBindingQSPort");
    static {
        URL url = null;
        try {
            url = new URL("http://22.1.32.54:8111/services/P00002000313?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RealtimeTransJobSrvSrvBindingQSService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://22.1.32.54:8111/services/P00002000313?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RealtimeTransJobSrvSrvBindingQSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RealtimeTransJobSrvSrvBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RealtimeTransJobSrvSrvBindingQSService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public RealtimeTransJobSrvSrvBindingQSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RealtimeTransJobSrvSrvBindingQSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RealtimeTransJobSrvSrvBindingQSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns RealtimeTransJobSrvSrvPortType
     */
    @WebEndpoint(name = "RealtimeTransJobSrvSrvBindingQSPort")
    public RealtimeTransJobSrvSrvPortType getRealtimeTransJobSrvSrvBindingQSPort() {
        return super.getPort(RealtimeTransJobSrvSrvBindingQSPort, RealtimeTransJobSrvSrvPortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RealtimeTransJobSrvSrvPortType
     */
    @WebEndpoint(name = "RealtimeTransJobSrvSrvBindingQSPort")
    public RealtimeTransJobSrvSrvPortType getRealtimeTransJobSrvSrvBindingQSPort(WebServiceFeature... features) {
        return super.getPort(RealtimeTransJobSrvSrvBindingQSPort, RealtimeTransJobSrvSrvPortType.class, features);
    }

}