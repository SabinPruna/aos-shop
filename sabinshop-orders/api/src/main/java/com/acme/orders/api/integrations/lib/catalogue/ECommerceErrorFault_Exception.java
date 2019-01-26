
package com.sabinshop.orders.api.integrations.lib.catalogue;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ECommerceErrorFault", targetNamespace = "http://sabinshop.com/services/eCommerce/v1")
public class ECommerceErrorFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ECommerceErrorFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ECommerceErrorFault_Exception(String message, ECommerceErrorFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ECommerceErrorFault_Exception(String message, ECommerceErrorFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.sabinshop.orders.api.integrations.lib.catalogue.ECommerceErrorFault
     */
    public ECommerceErrorFault getFaultInfo() {
        return faultInfo;
    }

}
