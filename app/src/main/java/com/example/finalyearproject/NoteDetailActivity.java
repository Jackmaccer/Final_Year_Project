package com.example.finalyearproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteDetailActivity extends AppCompatActivity {

    private TextView mtitleNoteDetail, mcontentNoteDetail;
    FloatingActionButton mgotoEditNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        mtitleNoteDetail = findViewById(R.id.titleNoteDetail);
        mcontentNoteDetail = findViewById(R.id.contentNoteDetail);
        mgotoEditNote = findViewById(R.id.gotoEditNote);
        Toolbar toolbar = findViewById(R.id.toolbarNoteDetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data = getIntent();

        mgotoEditNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), EditNoteActivity.class);
                i.putExtra("title", data.getStringExtra("title"));
                i.putExtra("content", data.getStringExtra("content"));
                i.putExtra("noteId", data.getStringExtra("noteId"));
                v.getContext().startActivity(i);

            }
        });

        mcontentNoteDetail.setText(data.getStringExtra("content"));
        mtitleNoteDetail.setText(data.getStringExtra("title"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}