/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.xoai.model.oaipmh;

import com.lyncode.xml.exceptions.XmlWriteException;
import org.dspace.xoai.xml.XmlWriter;

import java.util.ArrayList;
import java.util.List;

public class ListMetadataFormats implements Verb {
    protected final List<MetadataFormat> metadataFormats = new ArrayList<>();

    public List<MetadataFormat> getMetadataFormats() {
        return this.metadataFormats;
    }

    public ListMetadataFormats withMetadataFormat(MetadataFormat mdf) {
        metadataFormats.add(mdf);
        return this;
    }

    @Override
    public void write(XmlWriter writer) throws XmlWriteException {
        if (!this.metadataFormats.isEmpty())
            for (MetadataFormat format : this.metadataFormats)
                writer.writeElement("metadataFormat", format);
    }

    @Override
    public Type getType() {
        return Type.ListMetadataFormats;
    }
}
