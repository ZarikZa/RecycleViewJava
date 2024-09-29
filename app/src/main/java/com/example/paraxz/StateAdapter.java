package com.example.paraxz;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>{

    private static List<State> states = Collections.emptyList();
    private static Context context = null;
    private AdapterView.OnItemClickListener onItemClickListener;

    StateAdapter(Context context, List<State> states) {
        this.states = states;
        this.context = context;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flag.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView flag;
        TextView nameView;
        TextView capitalView;

        ViewHolder(View view) {
            super(view);
            flag = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                State state = states.get(position);
                Intent intent = new Intent(context, openPage.class);
                intent.putExtra("textNazv", state.getName());
                intent.putExtra("flagOpen", state.getFlagResource());
                intent.putExtra("opisOpen", state.getCapital());
                Toast toast = Toast.makeText(context,
                        state.getCapital(), Toast.LENGTH_LONG);
                toast.show();
                context.startActivity(intent);
            }
        }
    }
}
