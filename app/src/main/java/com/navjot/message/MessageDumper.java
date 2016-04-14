package com.navjot.message;

import android.database.Cursor;

import com.navjot.models.Message;
import com.navjot.storage.FileStorageHelper;

/**
 * Created by navjot on 9/4/16.
 */
public class MessageDumper {
    private Cursor cursor;
    private FileStorageHelper fileStorageHelper;
    private MessageReader messageReader;

    public MessageDumper (Cursor cursor, FileStorageHelper fileStorageHelper) {
        messageReader = new MessageReader(cursor);
        this.fileStorageHelper = fileStorageHelper;
    }

    public int dumpMessages() {
        int noOfMessagesDumped = 0;
        while(this.messageReader.hasNext()) {
            Message message = this.messageReader.getMessage();
            String csv = message.messageCSV();
            this.fileStorageHelper.writeCSVString(csv);
            noOfMessagesDumped += 1;
        }
        this.fileStorageHelper.closeStream();
        return noOfMessagesDumped;
    }
}
