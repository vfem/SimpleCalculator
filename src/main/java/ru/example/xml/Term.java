
package ru.example.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
public class Term {

    @XmlSchemaType(name = "nonNegativeInteger")
    protected List<Integer> arg;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected Integer arg1;
    protected Term operation1;
    protected Term operation2;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected Integer arg2;
    protected List<Term> operation;
    @XmlAttribute(name = "OperationType")
    protected String operationType;

    public List<Integer> getArg() {
        if (arg == null) {
            arg = new ArrayList<Integer>();
        }
        return this.arg;
    }

    public Integer getArg1() {
        return arg1;
    }

    public void setArg1(Integer value) {
        this.arg1 = value;
    }

    public Term getOperation1() {
        return operation1;
    }

    public void setOperation1(Term value) {
        this.operation1 = value;
    }

    public Term getOperation2() {
        return operation2;
    }

    public void setOperation2(Term value) {
        this.operation2 = value;
    }

    public Integer getArg2() {
        return arg2;
    }

    public void setArg2(Integer value) {
        this.arg2 = value;
    }

    public List<Term> getOperation() {
        if (operation == null) {
            operation = new ArrayList<Term>();
        }
        return this.operation;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String value) {
        this.operationType = value;
    }

}
