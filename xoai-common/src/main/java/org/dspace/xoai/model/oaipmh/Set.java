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
import org.dspace.xoai.model.xoai.XOAIMetadata;
import org.dspace.xoai.xml.XmlWritable;
import org.dspace.xoai.xml.XmlWriter;

import java.util.ArrayList;
import java.util.List;

public class Set implements XmlWritable {

    private String spec;
    private String name;
    private final List<Description> descriptions = new ArrayList<>();

    public String getSpec() {
        return spec;
    }

    public Set withSpec(String value) {
        this.spec = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public Set withName(String value) {
        this.name = value;
        return this;
    }

    public List<Description> getDescriptions() {
        return this.descriptions;
    }

    public Set withDescription(XOAIMetadata description) {
        this.descriptions.add(new Description(description));
        return this;
    }

    @Override
    public void write(XmlWriter writer) throws XmlWriteException {
        writer.writeElement("setSpec", spec);
        writer.writeElement("setName", name);
        if (this.descriptions != null && !this.descriptions.isEmpty()) {
            for (Description desc : this.descriptions)
                writer.writeElement("setDescription", desc);
        }
    }
}
