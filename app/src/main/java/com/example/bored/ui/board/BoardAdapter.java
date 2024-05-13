package com.example.bored.ui.board;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored.Prefs;
import com.example.bored.R;
import com.example.bored.databinding.ItemBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    ItemBoardBinding binding;
    NavController navController;

    private int [] images = new int[] {R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3};

    private String [] title = new String[]{
            "Do you want to do something for human and Earth?",
            "Do you want to do something for people?",
            "Do you want to do something for youself?"
    };

    @NonNull
    @Override
    public BoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemBoardBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(ItemBoardBinding itemView) {
            super(itemView.getRoot());
        }

        public void bind(int position) {

            binding.textBoard.setText(title[position]);
            binding.imageBoard.setImageResource(images[position]);




            if(position == images.length-1){
                binding.btnStart.setVisibility(View.VISIBLE);
            }else {
                binding.btnStart.setVisibility(View.INVISIBLE);
            }

            binding.btnStart.setOnClickListener(v->{

                new Prefs((Activity)itemView.getContext()).saveBoardState();

                navController = Navigation.findNavController((Activity) itemView.getContext(),
                        R.id.nav_host);
                navController.navigate(R.id.action_navigation_board_to_navigation_home);
            });
        }
    }





}