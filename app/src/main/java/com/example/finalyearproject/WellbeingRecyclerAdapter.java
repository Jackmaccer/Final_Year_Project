package com.example.finalyearproject;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class WellbeingRecyclerAdapter {
/*
    Context context;
    ArrayList<Note> noteArrayList;

    public WellbeingRecyclerAdapter(Context context, ArrayList<Note> noteArrayList) {
        this.context = context;
        this.noteArrayList = noteArrayList;
    }


    @NonNull
    @Override
    public WellbeingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.note_row, parent, false);
        return new WellbeingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WellbeingViewHolder holder, int position)
    {
        Note note = noteArrayList.get(position);
        holder.noteTV.setText(note.getText());
        CharSequence dateCharSeq = DateFormat.format("EEEE, MMM d, yyyy", note.getCreated().toDate());
        holder.dateTV.setText(dateCharSeq);

    }

    public static class WellbeingViewHolder extends RecyclerView.ViewHolder{

        TextView noteTV,dateTV;

        public WellbeingViewHolder(@NonNull View itemView) {
            super(itemView);

            noteTV = itemView.findViewById(R.id.noteTV);
            dateTV = itemView.findViewById(R.id.dateTV);
        }
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }*/
}
