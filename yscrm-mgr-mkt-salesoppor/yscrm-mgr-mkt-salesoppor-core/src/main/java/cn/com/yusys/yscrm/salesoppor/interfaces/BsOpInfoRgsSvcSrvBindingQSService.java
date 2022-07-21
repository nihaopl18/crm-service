package cn.com.yusys.yscrm.salesoppor.interfaces;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-14T11:51:29.972+08:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "BsOpInfoRgsSvcSrvBindingQSService",
                  wsdlLocation = "file:/C:/Users/USER/AppData/Local/Temp/tempdir6938866255658247841.tmp/P00002003051_1.wsdl",
                  targetNamespace = "http://www.whrcbank.com")
public class BsOpInfoRgsSvcSrvBindingQSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.whrcbank.com", "BsOpInfoRgsSvcSrvBindingQSService");
    public final static QName BsOpInfoRgsSvcSrvBindingQSPort = new QName("http://www.whrcbank.com", "BsOpInfoRgsSvcSrvBindingQSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/USER/AppData/Local/Temp/tempdir6938866255658247841.tmp/P00002003051_1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BsOpInfoRgsSvcSrvBindingQSService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/USER/AppData/Local/Temp/tempdir6938866255658247841.tmp/P00002003051_1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BsOpInfoRgsSvcSrvBindingQSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BsOpInfoRgsSvcSrvBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BsOpInfoRgsSvcSrvBindingQSService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BsOpInfoRgsSvcSrvBindingQSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BsOpInfoRgsSvcSrvBindingQSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BsOpInfoRgsSvcSrvBindingQSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BsOpInfoRgsSvcSrvPortType
     */
    @WebEndpoint(name = "BsOpInfoRgsSvcSrvBindingQSPort")
    public BsOpInfoRgsSvcSrvPortType getBsOpInfoRgsSvcSrvBindingQSPort() {
        return super.getPort(BsOpInfoRgsSvcSrvBindingQSPort, BsOpInfoRgsSvcSrvPortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BsOpInfoRgsSvcSrvPortType
     */
    @WebEndpoint(name = "BsOpInfoRgsSvcSrvBindingQSPort")
    public BsOpInfoRgsSvcSrvPortType getBsOpInfoRgsSvcSrvBindingQSPort(WebServiceFeature... features) {
        return super.getPort(BsOpInfoRgsSvcSrvBindingQSPort, BsOpInfoRgsSvcSrvPortType.class, features);
    }

}