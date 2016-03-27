package com.navjot.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.navjot.models.Tag;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by navjot on 26/3/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "TaskList";

    //Drop table prefix
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    //Table Name
    private static final String TABLE_TAG = "Tag";
    private static final String TABLE_TAG_AND_TAGGED = "TagAndTagged";

    //Common Columns
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_ON = "created_on";

    //Columns for Tag
    private static final String KEY_TAG_NAME = "tag_name";

    //Columns for TagAndTagged
    private static final String KEY_TAG_ID = "tag_id";
    private static final String KEY_TAGGED_ID = "tagged_id";
    private static final String KEY_TAGGED_RESOURCE_URI = "tagged_resource_uri";

    //Table creation statements
    //Tag Table creation
    private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_TAG + "(" + KEY_ID +
            " INTEGER PRIMARY KEY," + KEY_TAG_NAME + " TEXT," + KEY_CREATED_ON + " DATETIME" + ")";

    //TagAndTagged Table creation
    private static final String CREAT_TABLE_TAG_AND_TAGGED = "CREATE TABLE " + TABLE_TAG_AND_TAGGED
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TAG_ID + " INTEGER," + KEY_TAGGED_ID +
            " INTEGER," + KEY_TAGGED_RESOURCE_URI + " TEXT" + KEY_CREATED_ON + "DATETIME" + ")";


    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating Tables
        db.execSQL(CREATE_TABLE_TAG);
        db.execSQL(CREAT_TABLE_TAG_AND_TAGGED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // On Upgrade drop existing tables
        db.execSQL(DROP_TABLE + TABLE_TAG);
        db.execSQL(DROP_TABLE + TABLE_TAG_AND_TAGGED);

        onCreate(db);
    }

    /**
     * Methods for TAG
     */
    public long createTag(Tag tag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, tag.getId());
        values.put(KEY_TAG_NAME, tag.getTagName());
        values.put(KEY_CREATED_ON, getDateTime());

        long tagId = db.insert(TABLE_TAG, null, values);

        return tagId;
    }

    public Tag getTag(long id) {
        
    }

    /**
     * get datetime
     * */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
