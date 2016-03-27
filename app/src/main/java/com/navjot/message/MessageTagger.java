package com.navjot.message;

import android.database.Cursor;

import com.navjot.filter.MessageFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by navjot on 23/3/16.
 */
public class MessageTagger {
    private MessageFilter[] filters = null;
    private Cursor cursor;

    public MessageTagger(Cursor cursor) {
        this.cursor = cursor;
    }

    public String getNextMessage() {
        try {
            cursor.moveToNext();
            String message = "";
            int index = 0;
            for (String colName : cursor.getColumnNames()) {
                int type = cursor.getType(index);
                if (type == Cursor.FIELD_TYPE_STRING)
                    message = message + colName + ": " + cursor.getString(index) + " \n";
                else if (type == Cursor.FIELD_TYPE_BLOB)
                    message = message + colName + ": " + cursor.getBlob(index) + " \n";
                else if (type == Cursor.FIELD_TYPE_FLOAT)
                    message = message + colName + ": " + cursor.getFloat(index) + " \n";
                else if (type == Cursor.FIELD_TYPE_INTEGER) {
                    if (colName.contains("date"))
                        message = message + colName + ": " + (new Date(cursor.getLong(index))) + " \n";
                    else
                        message = message + colName + ": " + cursor.getLong(index) + " \n";
                }
                index++;
            }
            message = message + "\n";
            return message;
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    }
}
