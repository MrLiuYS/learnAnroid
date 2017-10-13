package com.mrliuys.android.notebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mrliuys.android.notebook.home.NotebookAdapter;
import com.mrliuys.android.notebook.home.NotebookModel;
import com.mrliuys.android.notebook.info.InfoActivity;

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

        NotebookAdapter adapter = new NotebookAdapter(MainActivity.this, R.layout.cell_main, R.id.main_cell_title,
                notebookModelList);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                NotebookModel model = notebookModelList.get(position);

                InfoActivity.push(MainActivity.this,model);

            }
        });


    }


    private void initNoteBooks() {

        for (int index = 0; index < 40; index++) {

            NotebookModel model = new NotebookModel(index, "asdasd" + index, "qweqwe");

            notebookModelList.add(model);
        }

    }


}
