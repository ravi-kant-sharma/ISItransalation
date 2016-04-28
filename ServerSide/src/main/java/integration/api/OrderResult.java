
package integration.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://API.Integration/}Result">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://API.Integration/}Order" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderResult", propOrder = {
    "data"
})
public class OrderResult
    extends Result
{

    protected Order data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setData(Order value) {
        this.data = value;
    }

}
