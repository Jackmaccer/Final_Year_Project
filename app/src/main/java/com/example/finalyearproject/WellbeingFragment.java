package com.example.finalyearproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class WellbeingFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Note> noteArrayList;
    WellbeingRecyclerAdapter wbAdapter;
    FirebaseFirestore db;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_wellbeing, container, false);

        Button btn1 = (Button) v.findViewById(R.id.addNoteBT);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), WellbeingActivity.class);
                startActivity(i);
            }
        });

        /*recyclerView = v.findViewById(R.id.wellbeingRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        db = FirebaseFirestore.getInstance();
        noteArrayList = new ArrayList<Note>();
        wbAdapter = new WellbeingRecyclerAdapter(getActivity(), noteArrayList);

        recyclerView.setAdapter(wbAdapter);

        WellbeingChangeListner();*/
        return v;
    }
/*
    private void WellbeingChangeListner()
    {
        db.collection("Note").orderBy("created", Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null)
                        {
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc: value.getDocumentChanges())
                        {
                            if(dc.getType() == DocumentChange.Type.ADDED)
                            {
                                noteArrayList.add(dc.getDocument().toObject(Note.class));

                            }
                            wbAdapter.notifyDataSetChanged();
                        }

                    }
                });


    }


    private void initRecyclerView(FirebaseUser user)
    {
        Query query = FirebaseFirestore.getInstance()
                .collection("notes")
                .whereEqualTo("userId",user.getUid());

        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class)
                .build();

        wellbeingRecyclerAdapter = new WellbeingRecyclerAdapter(options);
        recyclerView.setAdapter(wellbeingRecyclerAdapter);
        wellbeingRecyclerAdapter.startListening();
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
    {
        initRecyclerView(Objects.requireNonNull(firebaseAuth.getCurrentUser()));

    }*/
}