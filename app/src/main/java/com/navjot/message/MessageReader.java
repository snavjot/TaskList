package com.navjot.message;

import android.database.Cursor;

import com.navjot.models.Message;

/**
 * Created by navjot on 9/4/16.
 */
public class MessageReader {
    private Cursor cursor;

    public MessageReader(Cursor cursor) {
        this.cursor = cursor;
        this.cursor.moveToFirst();
    }

    public Message getMessage() {
        Message message = new Message();
        int index;
        int type;
        // Get Id
        index = cursor.getColumnIndex(Message.ID);
        type = cursor.getType(index);
        if (type == Cursor.FIELD_TYPE_INTEGER) {
            message.setId(cursor.getLong(index));
        }

        // Get Address
        index = cursor.getColumnIndex(Message.ADDREDSS);
        type = cursor.getType(index);
        if (type == Cursor.FIELD_TYPE_STRING) {
            message.setAddress(cursor.getString(index));
        }
        return message;
    }
}
