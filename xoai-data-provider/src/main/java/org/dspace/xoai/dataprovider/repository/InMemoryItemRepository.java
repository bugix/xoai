/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.xoai.dataprovider.repository;

import org.dspace.xoai.dataprovider.exceptions.IdDoesNotExistException;
import org.dspace.xoai.dataprovider.filter.ScopedFilter;
import org.dspace.xoai.dataprovider.handlers.results.ListItemIdentifiersResult;
import org.dspace.xoai.dataprovider.handlers.results.ListItemsResults;
import org.dspace.xoai.dataprovider.model.InMemoryItem;
import org.dspace.xoai.dataprovider.model.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.min;
import static java.util.Arrays.asList;

public class InMemoryItemRepository implements ItemRepository {
    private final List<InMemoryItem> list = new ArrayList<>();

    public InMemoryItemRepository withNoItems() {
        return this;
    }

    public InMemoryItemRepository withItem(InMemoryItem item) {
        list.add(item);
        return this;
    }

    public InMemoryItemRepository withItems(InMemoryItem... item) {
        list.addAll(asList(item));
        return this;
    }

    public InMemoryItemRepository withRandomItems(int number) {
        for (int i = 0; i < number; i++)
            list.add(InMemoryItem.randomItem());
        return this;
    }

    @Override
    public Item getItem(String identifier) throws IdDoesNotExistException {
        for (InMemoryItem item : this.list) {
            if (item.getIdentifier().equals(identifier))
                return item;
        }
        throw new IdDoesNotExistException();
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length) {
        return new ListItemIdentifiersResult(offset + length < list.size(), new ArrayList<>(list.subList(offset, min(offset + length, list.size()))));
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, Date from) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiersUntil(List<ScopedFilter> filters, int offset, int length, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, Date from, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, String setSpec) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiersUntil(List<ScopedFilter> filters, int offset, int length, String setSpec, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length) {
        return new ListItemsResults(offset + length < list.size(), new ArrayList<>(list.subList(offset, min(offset + length, list.size()))));
    }

    @Override
    public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, Date from) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItemsUntil(List<ScopedFilter> filters, int offset, int length, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, Date from, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItemsUntil(List<ScopedFilter> filters, int offset, int length, String setSpec, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from, Date until) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
