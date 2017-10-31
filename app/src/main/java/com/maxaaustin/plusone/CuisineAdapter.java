package com.maxaaustin.plusone;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by maaus on 10/30/2017.
 */

public class CuisineAdapter extends Adapter<CuisineAdapter.ViewHolder> {

    android.content.Context c;

    private String[] nameList = {
            "American", "Barbecue", "Chinese", "French", "Indian", "Italian", "Japanese", "Mediterranean", "Thai", "Vietnamese"
    };
    private int[] cuisineIconID = {
            R.drawable.american, R.drawable.bbq, R.drawable.chinese, R.drawable.french, R.drawable.indian, R.drawable.italian, R.drawable.japanese, R.drawable.mediterranean, com.maxaaustin.plusone.R.drawable.thai, com.maxaaustin.plusone.R.drawable.vietnamese
    };

    public CuisineAdapter(android.content.Context c) {
        this.c = c;
    }


    @Override
    public CuisineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = android.view.LayoutInflater.from(parent.getContext()).inflate(com.maxaaustin.plusone.R.layout.cuisine_rv_item, parent, false);
        return new com.maxaaustin.plusone.CuisineAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CuisineAdapter.ViewHolder holder, int position) {

        final String name = nameList[position];
        final int image = cuisineIconID[position];

        holder.mCuisineName.setText(name);
        holder.mCuisineImageNumber.setImageResource(image);
        holder.setCuisineClickListener(new CuisineClickListener() {
            @Override
            public void onCuisineClick(int position) {
                openHostDetailActivity();
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements android.view.View.OnClickListener{
        public android.content.Context context;
        android.support.v7.widget.CardView cv;
        public TextView mCuisineName;
        public ImageView mCuisineImageNumber;
        com.maxaaustin.plusone.CuisineClickListener mCuisineClickListener;

        public ViewHolder(final View itemView) {
            super(itemView);

            mCuisineName = itemView.findViewById(com.maxaaustin.plusone.R.id.cuisine_text_view);
            mCuisineImageNumber = itemView.findViewById(com.maxaaustin.plusone.R.id.cuisine_image_view);
            itemView.setOnClickListener(this);
            //cv = (android.support.v7.widget.CardView) itemView.findViewById(R.id.cv);
            itemView.setOnClickListener(this);
        }
        public void setCuisineClickListener(com.maxaaustin.plusone.CuisineClickListener mCuisineClickListener){
            this.mCuisineClickListener=mCuisineClickListener;
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(android.view.View v) {
            int pos = getAdapterPosition();
            this.mCuisineClickListener.onCuisineClick(pos);
        }

    }
    private void openHostDetailActivity(){
        android.content.Intent intent = new android.content.Intent(c, HostMain.class);
        c.startActivity(intent);
    }
}
