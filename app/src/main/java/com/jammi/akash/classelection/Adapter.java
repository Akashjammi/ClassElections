package com.jammi.akash.classelection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>{
//Context mContext;

    private List<Modelclass> mModelclassList;
    private Context context;
    public Adapter(List<Modelclass> modelclassList) {
        mModelclassList = modelclassList;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(com.jammi.akash.classelection.R.layout.item_layout,viewGroup,false);
        return  new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int position) {
      int resource =mModelclassList.get(position).getImgresource();
      String title = mModelclassList.get(position).getTitle();
      String body = mModelclassList.get(position).getBody();
      viewHolder.setData(resource,title,body);
//        mContext = this;
      viewHolder.setItemClickListener(new ItemClickListener() {
          @Override
          public void onClick(View view, int position, boolean isLongClick) {
              if(isLongClick)
              {
//                  Toast.makeText(Context,"",Toast.LENGTH_SHORT).show();
                  Toast.makeText(context,"Long click" + mModelclassList.get(position) ,Toast.LENGTH_SHORT).show();
                  Log.i("CLicked", String.valueOf(mModelclassList.get(position)));
              }
              else{
                  Toast.makeText(context," click" + mModelclassList.get(position) ,Toast.LENGTH_SHORT).show();
                  Log.i("CLicked", String.valueOf(mModelclassList.get(position)));
              }
          }
      });

    }

    @Override
    public int getItemCount() {
        return mModelclassList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener , View.OnClickListener{




          private ImageView mImageView;
          private TextView title;
          private TextView body;
        private ItemClickListener itemClickListener;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(com.jammi.akash.classelection.R.id.imageView2);
            title = itemView.findViewById(com.jammi.akash.classelection.R.id.title);
            body = itemView.findViewById(com.jammi.akash.classelection.R.id.body);

            mImageView.setOnClickListener(this);
            title.setOnClickListener(this);


        }
        private void setData(int resource,String titletext,String bodytext){
              mImageView.setImageResource(resource);
              title.setText(titletext);
              body.setText(bodytext);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
              this.itemClickListener =itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);

            Log.i("CLicked", String.valueOf(getAdapterPosition()));
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            Log.i("CLicked long", String.valueOf(getAdapterPosition()));
            return true;
        }
    }


}
