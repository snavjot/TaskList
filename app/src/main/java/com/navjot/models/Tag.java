package com.navjot.models;

/**
 * Created by navjot on 26/3/16.
 */
public class Tag {
    private long id;
    private String tagName;

    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag(long id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    /**
     * Set the id which is the Primary key of Tag
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Set the Name of the Tag
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Geter to get the Id of Tag object
     * @return
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for name of the Tag Object
     * @return
     */
    public String getTagName() {
        return this.tagName;
    }

}
