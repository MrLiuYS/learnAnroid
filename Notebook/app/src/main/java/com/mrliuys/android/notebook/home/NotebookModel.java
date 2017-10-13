package com.mrliuys.android.notebook.home;

import java.io.Serializable;

/**
 * Created by LiuYongSheng on 2017/10/13.
 */

public class NotebookModel implements Serializable{

    private String title;
    private String summary;
    private int noteID;

    public NotebookModel(int noteID, String title, String summary) {

        this.title = title;
        this.summary = summary;
        this.noteID = noteID;

    }

    public String getTitle() {

        return title;
    }

    public String getSummary() {
        return summary;

    }

    public int getNoteID() {
        return noteID;
    }
}
