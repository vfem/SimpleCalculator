
package ru.example.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for term complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="term">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="arg" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" maxOccurs="2" minOccurs="2"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *           &lt;element name="operation1" type="{}term"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="operation2" type="{}term"/>
 *           &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="operation" type="{}term" maxOccurs="2" minOccurs="2"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute ref="{}OperationType"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "term", propOrder = {
    "arg",
    "arg1",
    "operation1",
    "operation2",
    "arg2",
    "operation"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Term {

    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Integer> arg;
    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Integer arg1;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Term operation1;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Term operation2;
    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Integer arg2;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Term> operation;
    @XmlAttribute(name = "OperationType")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String operationType;

    /**
     * Gets the value of the arg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Integer> getArg() {
        if (arg == null) {
            arg = new ArrayList<Integer>();
        }
        return this.arg;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Integer getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setArg1(Integer value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the operation1 property.
     * 
     * @return
     *     possible object is
     *     {@link Term }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Term getOperation1() {
        return operation1;
    }

    /**
     * Sets the value of the operation1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Term }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOperation1(Term value) {
        this.operation1 = value;
    }

    /**
     * Gets the value of the operation2 property.
     * 
     * @return
     *     possible object is
     *     {@link Term }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Term getOperation2() {
        return operation2;
    }

    /**
     * Sets the value of the operation2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Term }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOperation2(Term value) {
        this.operation2 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Integer getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setArg2(Integer value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Term }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Term> getOperation() {
        if (operation == null) {
            operation = new ArrayList<Term>();
        }
        return this.operation;
    }

    /**
     * Gets the value of the operationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-01-28T09:23:30+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOperationType(String value) {
        this.operationType = value;
    }

}
