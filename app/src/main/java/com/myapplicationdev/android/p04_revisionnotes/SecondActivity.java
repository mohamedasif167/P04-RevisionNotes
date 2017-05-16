package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
        setContentView(R.layout.activity_second);

		lv = (ListView) findViewById(R.id.lv);
        DBHelper db = new DBHelper(SecondActivity.this);
        ArrayList<Note> data = db.getAllNotes();

        for(int i =0;i < data.size();i++){
            Log.d("Testing Data Array", data.get(i).getNoteContent());
        }
        Log.d("Testing", "Testing: ");
        aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, data);

        lv.setAdapter(aa);
        db.close();
	}


}
