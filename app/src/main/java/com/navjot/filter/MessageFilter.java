package com.navjot.filter;

/**
 * Created by navjot on 23/3/16.
 */
public interface MessageFilter {
    public String[] getTags(Object message);

    public boolean isFilterApplicable(Object message);

    public void setFilterCriteria();

    public void setApplicableTags(String [] tags);
}
