package com.navjot.tasklist;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.navjot.message.MessageTagger;

public class DisplayMessageActivity extends AppCompatActivity {

    private MessageTagger messageTagger = null;
    int REQUEST_CODE_ASK_PERMISSIONS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String exMessage = "";
        try {
            if(!(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") == PackageManager.PERMISSION_GRANTED)) {
                ActivityCompat.requestPermissions(DisplayMessageActivity.this, new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);
            }
            Uri smsInboxUri = Uri.parse("content://sms/inbox");
            Cursor dataBaseCursor = getContentResolver().query(smsInboxUri, null, null, null, null);
            messageTagger = new MessageTagger(dataBaseCursor);
        }
        catch (Exception ex) {
            exMessage = ex.getMessage();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message + exMessage);
        textView.setId(R.id.view_1_id);

        LinearLayout layout = (LinearLayout) findViewById(R.id.content);
        layout.addView(textView, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.add_message) {
            return this.addMessage(item);
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean addMessage(MenuItem item) {

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText(messageTagger.getNextMessage());
        LinearLayout layout = (LinearLayout) findViewById(R.id.content);
        TextView newTextView = (TextView) findViewById(R.id.view_1_id);
        //layout.addView(newTextView);
        layout.addView(textView);
        return true;
    }

}
