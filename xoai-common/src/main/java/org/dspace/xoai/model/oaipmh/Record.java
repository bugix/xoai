/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147
// See <a href="client://java.sun.com/xml/jaxb">client://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2012.01.13 at 08:24:23 PM WET
//

package org.dspace.xoai.model.oaipmh;

import com.lyncode.xml.exceptions.XmlWriteException;
import org.dspace.xoai.xml.XmlWritable;
import org.dspace.xoai.xml.XmlWriter;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;
import java.util.List;

public class Record implements XmlWritable {

    protected Header header;
    protected Metadata metadata;
    protected List<About> abouts = new ArrayList<>();

    public Header getHeader() {
        return header;
    }

    public Record withHeader(Header value) {
        this.header = value;
        return this;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Record withMetadata(Metadata value) {
        this.metadata = value;
        return this;
    }

    public Record withAbout(About itemAbout) {
        this.abouts.add(itemAbout);
        return this;
    }

    public List<About> getAbouts() {
        return this.abouts;
    }

    @Override
    public void write(XmlWriter writer) throws XmlWriteException {
        try {
            if (this.header != null) {
                writer.writeStartElement("header");
                this.header.write(writer);
                writer.writeEndElement();
            }

            if (this.metadata != null) {
                writer.writeStartElement("metadata");
                this.metadata.write(writer);
                writer.writeEndElement();
            }

            for (About about : getAbouts()) {
                writer.writeStartElement("about");
                about.write(writer);
                writer.writeEndElement();
            }

        } catch (XMLStreamException e) {
            throw new XmlWriteException(e);
        }
    }
}
