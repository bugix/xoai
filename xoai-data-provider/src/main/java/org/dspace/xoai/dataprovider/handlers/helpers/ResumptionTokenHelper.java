/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.xoai.dataprovider.handlers.helpers;

import org.dspace.xoai.model.oaipmh.ResumptionToken;

import static com.google.common.base.Predicates.isNull;
import static java.lang.Math.round;

public class ResumptionTokenHelper {
    private final ResumptionToken.Value current;
    private final long maxPerPage;
    private Long totalResults;

    public ResumptionTokenHelper(ResumptionToken.Value current, long maxPerPage) {
        this.current = current;
        this.maxPerPage = maxPerPage;
    }

    public ResumptionTokenHelper withTotalResults(long totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public ResumptionToken resolve(boolean hasMoreResults) {
        if (isInitialOffset() && !hasMoreResults) return null;
        else {
            if (hasMoreResults) {
                ResumptionToken.Value next = current.next(maxPerPage);
                return populate(new ResumptionToken(next));
            } else {
                ResumptionToken resumptionToken = new ResumptionToken();
                resumptionToken.withCursor(round((current.getOffset() + maxPerPage) / maxPerPage));
                if (totalResults != null)
                    resumptionToken.withCompleteListSize(totalResults);
                return resumptionToken;
            }
        }
    }

    private boolean isInitialOffset() {
        return isNull().apply(current.getOffset()) || current.getOffset() == 0;
    }

    private ResumptionToken populate(ResumptionToken resumptionToken) {
        if (totalResults != null)
            resumptionToken.withCompleteListSize(totalResults);
        resumptionToken.withCursor(round(resumptionToken.getValue().getOffset() / maxPerPage));
        return resumptionToken;
    }
}
