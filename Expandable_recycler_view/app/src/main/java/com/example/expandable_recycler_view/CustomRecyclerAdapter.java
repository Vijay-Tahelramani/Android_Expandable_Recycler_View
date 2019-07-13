package com.example.expandable_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder> {

    private List<Products> productsList;

    public CustomRecyclerAdapter(List<Products> productsList) {
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        final Products products = productsList.get(position);

        holder.bind(products);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expanded = products.isExpanded();
                products.setExpanded(!expanded);
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList == null ? 0 : productsList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView product_name,product_type,product_rating;
        private View HiddenView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name);
            product_type = itemView.findViewById(R.id.product_type);
            product_rating = itemView.findViewById(R.id.product_rating);
            HiddenView = itemView.findViewById(R.id.hidden_view);

        }

        private void bind(Products products) {
            boolean expanded = products.isExpanded();

            HiddenView.setVisibility(expanded ? View.VISIBLE : View.GONE);

            product_name.setText(products.getProductName());
            product_type.setText("Type: " + products.getProductType());
            product_rating.setText("Rating: " + products.getProductRating());
        }
    }
}
