
package integration.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntegerResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegerResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://API.Integration/}Result">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegerResult", propOrder = {
    "data"
})
public class IntegerResult
    extends Result
{

    protected int data;

    /**
     * Gets the value of the data property.
     * 
     */
    public int getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     */
    public void setData(int value) {
        this.data = value;
    }

}
