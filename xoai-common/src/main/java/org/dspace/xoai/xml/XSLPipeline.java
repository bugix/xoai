/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.xoai.xml;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XSLPipeline {
    private InputStream inputStream;
    private ByteArrayOutputStream outputStream;
    private final List<Transformer> transformers = new ArrayList<>();
    private final boolean omitXMLDeclaration;

    public XSLPipeline(InputStream inputStream, boolean omitXMLDeclaration) {
        this.inputStream = inputStream;
        this.omitXMLDeclaration = omitXMLDeclaration;
    }

    public XSLPipeline apply(Transformer xslTransformer) {
        transformers.add(xslTransformer);
        return this;
    }

    public InputStream process() throws TransformerException {
        for (Transformer transformer : transformers) {
            outputStream = new ByteArrayOutputStream();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, (omitXMLDeclaration) ? "yes" : "no");
            transformer.transform(new StreamSource(inputStream), new StreamResult(outputStream));
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        }
        return inputStream;
    }
}
