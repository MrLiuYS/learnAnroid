package com.mrliuys.android.notebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.mrliuys.android.notebook.model.NotebookModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;

    private List<NotebookModel> notebookModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initNoteBooks();

        listView = (ListView) findViewById(R.id.main_listView);


        NotebookAdapter adapter = new NotebookAdapter(MainActivity.this, R.layout.cell_main,R.id.main_cell_title, notebookModelList);

        listView.setAdapter(adapter);



    }


    private void initNoteBooks() {

        for (int index = 0; index < 40; index++) {

            NotebookModel model = new NotebookModel(index, "asdasd" + index, "qweqwe");

            notebookModelList.add(model);
        }

    }


}
