package com.navjot.models;

/**
 * Created by navjot on 26/3/16.
 */
public class TagAndTagged {

    private long id;
    private long tagId;
    private long taggedId;
    private String taggedResourceUri;

    public TagAndTagged() {

    }

    public TagAndTagged(long id) {
        this.id = id;
    }

    public TagAndTagged(long id, long tagId, long taggedId) {
        this.id = id;
        this.tagId = tagId;
        this.taggedId = taggedId;
    }

    public TagAndTagged(long id, long tagId, long taggedId, String taggedResourceUri) {
        this.id = id;
        this.tagId = tagId;
        this.taggedId = taggedId;
        this.taggedResourceUri = taggedResourceUri;
    }

    public long getId() {
        return this.id;
    }

    public long getTagId() {
        return this.tagId;
    }

    public long getTaggedId() {
        return this.taggedId;
    }

    public String getTaggedResourceUri() {
        return this.taggedResourceUri;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public void setTaggedId(long taggedId) {
        this.taggedId = taggedId;
    }

    public void setTaggedResourceUri(String taggedResourceUri) {
        this.taggedResourceUri = taggedResourceUri;
    }
}

