/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="client://java.sun.com/xml/jaxb">client://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2012.06.27 at 01:16:00 PM WEST
//

package org.dspace.xoai.model.xoai;

import com.lyncode.xml.XmlReader;
import com.lyncode.xml.XmlWritable;
import com.lyncode.xml.XmlWriter;
import com.lyncode.xml.exceptions.XmlReaderException;
import com.lyncode.xml.exceptions.XmlWriteException;
import org.dspace.xoai.services.api.MetadataSearch;
import org.dspace.xoai.services.impl.MetadataSearchImpl;
import org.dspace.xoai.xml.XSISchema;

import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.lyncode.xml.matchers.QNameMatchers.localPart;
import static com.lyncode.xml.matchers.XmlEventMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;

public class XOAIMetadata implements XmlWritable {

    private static final String DEFAULT_FIELD = "value";

    public static XOAIMetadata parse (InputStream inputStream) throws XmlReaderException {
        XmlReader reader = new XmlReader(inputStream);
        XOAIMetadata XOAIMetadata = new XOAIMetadata();
        if (!reader.next(aStartElement()).current(allOf(aStartElement(), elementName(localPart(equalTo("metadata"))))))
            throw new XmlReaderException("Invalid XML. Expecting entity 'metadata'");

        while (reader.next(anElement()).current(aStartElement())) {
            if (reader.current(elementName(localPart(equalTo("element"))))) // Nested element
                XOAIMetadata.withElement(Element.parse(reader));
            else throw new XmlReaderException("Unexpected element");
        }

        if (!reader.current(allOf(anEndElement(), elementName(localPart(equalTo("metadata"))))))
            throw new XmlReaderException("Invalid XML. Expecting end of entity 'metadata'");

        reader.close();
        return XOAIMetadata;
    }


    public static final String NAMESPACE_URI = "http://www.lyncode.com/xoai";
    public static final String SCHEMA_LOCATION = "http://www.lyncode.com/xsd/xoai.xsd";

    protected final List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return this.elements;
    }

    public XOAIMetadata withElement (Element element) {
        this.elements.add(element);
        return this;
    }

    public String toString() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            this.write(new XmlWriter(out));
        } catch (XmlWriteException | XMLStreamException e) {
            // don't do anything
        }
        return out.toString();
    }

    @Override
    public void write(XmlWriter writer) throws XmlWriteException {
        try {
            writer.setDefaultNamespace(NAMESPACE_URI);
            writer.writeStartElement("metadata");
            writer.writeDefaultNamespace(NAMESPACE_URI);
            writer.writeNamespace(XSISchema.PREFIX, XSISchema.NAMESPACE_URI);
            writer.writeAttribute(XSISchema.PREFIX, XSISchema.NAMESPACE_URI, "schemaLocation",
                    NAMESPACE_URI + " " + SCHEMA_LOCATION);

            for (Element element : getElements()) {
                writer.writeStartElement(NAMESPACE_URI, "element");
                element.write(writer);
                writer.writeEndElement();
            }
            writer.writeEndElement();
        } catch (XMLStreamException e) {
            throw new XmlWriteException(e);
        }
    }

    /**
     * @return a simple searcher that returns search results as String elements.
     */
    public MetadataSearch<String> searcher () {
        return new MetadataSearchImpl(this);
    }

}
