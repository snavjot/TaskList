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
        try {
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

            // Get Date
            index = cursor.getColumnIndex(Message.DATE);
            type = cursor.getType(index);
            if (type == Cursor.FIELD_TYPE_INTEGER) {
                message.setDate(cursor.getLong(index));
            }

            // Get Sent Date
            index = cursor.getColumnIndex(Message.SENTDATE);
            type = cursor.getType(index);
            if (type == Cursor.FIELD_TYPE_INTEGER) {
                message.setSentDate(cursor.getLong(index));
            }

            // Get Person Id
            index = cursor.getColumnIndex(Message.PERSONID);
            if (index != -1) {
                type = cursor.getType(index);
                if (type == Cursor.FIELD_TYPE_INTEGER) {
                    message.setPersonId(cursor.getLong(index));
                } else {
                    message.setPersonId(-1);
                }
            } else {
                message.setPersonId(-1);
            }

            // Get Body
            index = cursor.getColumnIndex(Message.BODY);
            type = cursor.getType(index);
            if (type == Cursor.FIELD_TYPE_STRING) {
                message.setBody(cursor.getString(index));
            }
        }
        catch (Exception ex) {

        }
        return message;
    }
}
