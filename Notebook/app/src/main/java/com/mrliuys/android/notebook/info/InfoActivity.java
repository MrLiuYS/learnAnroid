package com.mrliuys.android.notebook.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.mrliuys.android.notebook.R;
import com.mrliuys.android.notebook.home.NotebookModel;

public class InfoActivity extends AppCompatActivity {


private EditText infoEditText;


    public static void push(Context context , NotebookModel model) {

        Intent intent = new Intent(context, InfoActivity.class);

        intent.putExtra("InfoActivity", model);

        context.startActivity(intent);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        infoEditText = (EditText) findViewById(R.id.infoEditText);


        Intent intent  = getIntent();

        NotebookModel model = (NotebookModel) intent.getSerializableExtra("InfoActivity");

        setTitle(model.getTitle());



        infoEditText.setText(model.getSummary());

    }
}
