package com.navjot.message;

import android.database.Cursor;

import com.navjot.storage.FileStorageHelper;

/**
 * Created by navjot on 9/4/16.
 */
public class MessageDumper {
    private Cursor cursor;
    private FileStorageHelper fileStorageHelper;

    public MessageDumper (Cursor cursor, FileStorageHelper fileStorageHelper) {
        this.cursor = cursor;
        this.fileStorageHelper = fileStorageHelper;
    }


}
