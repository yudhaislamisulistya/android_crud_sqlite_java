package com.tabian.saveanddisplaysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 2/28/2017.
 */

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button btnSave,btnDelete;
    private EditText editable_item, editable_item2;

    DatabaseHelper mDatabaseHelper;

    private String selectedName;
    private String selectedNohp;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        editable_item = (EditText) findViewById(R.id.editable_item);
        editable_item2 = (EditText) findViewById(R.id.editable_item2);
        mDatabaseHelper = new DatabaseHelper(this);

        Intent receivedIntent = getIntent();

        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        selectedName = receivedIntent.getStringExtra("name");

        selectedNohp = receivedIntent.getStringExtra("nohp");

        editable_item.setText(selectedName);
        editable_item2.setText(selectedNohp);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editable_item.getText().toString();
                String nohp = editable_item2.getText().toString();
                if(!item.equals("") && !nohp.equals("")){
                    mDatabaseHelper.updateName(item,nohp,selectedID);
                    toastMessage("Data Berhasil Diubah");
                }else{
                    toastMessage("You must enter a name");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedID,selectedName);
                editable_item.setText("");
                editable_item2.setText("");
                toastMessage("Data Berhasil dihapus");
            }
        });

    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
























