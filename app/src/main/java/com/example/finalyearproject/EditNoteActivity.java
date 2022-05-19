package com.example.finalyearproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditNoteActivity extends AppCompatActivity {

    Intent data;
    EditText meditTitleNote, meditContentNote;
    FloatingActionButton msaveEditNote;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        meditTitleNote = findViewById(R.id.editTitleNote);
        meditContentNote = findViewById(R.id.editContentNote);
        msaveEditNote = findViewById(R.id.saveEditNote);

        data = getIntent();

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Toolbar toolbar = findViewById(R.id.toolbarEditNote);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        msaveEditNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String newTitle = meditTitleNote.getText().toString();
                String newContent = meditContentNote.getText().toString();

                if(newTitle.isEmpty() || newContent.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Something is Empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DocumentReference documentReference = firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("myNotes").document(data.getStringExtra("noteId"));
                    Map<String, Object> note = new HashMap<>();
                    note.put("title", newTitle);
                    note.put("content", newContent);
                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused)
                        {
                            Toast.makeText(getApplicationContext(), "Note is updated",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(EditNoteActivity.this, WellbeingActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(getApplicationContext(), "Note failed to updated",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        String noteTitle = data.getStringExtra("title");
        String noteContent = data.getStringExtra("content");
        meditContentNote.setText(noteContent);
        meditTitleNote.setText(noteTitle);

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