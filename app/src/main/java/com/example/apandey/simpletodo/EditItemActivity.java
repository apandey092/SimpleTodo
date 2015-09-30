package com.example.apandey.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    private static int REQUEST_CODE = 200;

    EditText etNewItem;

    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        pos = getIntent().getIntExtra("pos", 0);
        String data = getIntent().getStringExtra("data");
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(data);
        etEditItem.setCursorVisible(true);
        etEditItem.setSelection(data.length());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    public void onSaveItem(View v) {
        EditText etName = (EditText) findViewById(R.id.etEditItem);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("data", etName.getText().toString());
        data.putExtra("pos", pos);
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // close
        // closes the activity and returns to first screen
//        this.finish();
    }

}
