
package integration.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BooleanResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BooleanResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://API.Integration/}Result">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BooleanResult", propOrder = {
    "data"
})
public class BooleanResult
    extends Result
{

    protected boolean data;

    /**
     * Gets the value of the data property.
     * 
     */
    public boolean isData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     */
    public void setData(boolean value) {
        this.data = value;
    }

}
