package com.prateek.mynotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.prateek.mynotes.databinding.EachNoteBinding;

public class RVAdapter extends ListAdapter<Note,RVAdapter.ViewHolder> {

    public RVAdapter(){
        super(CALLBACK);
    }

    private static DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getDescription().equals(newItem.getDescription());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_note,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note= getItem(position);
        holder.binding.tvTitle.setText(note.getTitle());
        holder.binding.tvDescription.setText(note.getDescription());
    }

    public Note getNote(int position)
    {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        EachNoteBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=EachNoteBinding.bind(itemView);
        }
    }
}
