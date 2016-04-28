
package integration.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoubleResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DoubleResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://API.Integration/}Result">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DoubleResult", propOrder = {
    "data"
})
public class DoubleResult
    extends Result
{

    protected double data;

    /**
     * Gets the value of the data property.
     * 
     */
    public double getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     */
    public void setData(double value) {
        this.data = value;
    }

}
