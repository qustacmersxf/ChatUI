package com.example.elephantfly.chatui;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ElephantFly on 2017/7/23.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> msgList;
    View view;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView smgContent;
        ImageView imageLeft, imageRight;

        public ViewHolder(View v){
            super(v);
            smgContent = (TextView)v.findViewById(R.id.msg_content);
            imageLeft = (ImageView)v.findViewById(R.id.user_image_left);
            imageRight = (ImageView)v.findViewById(R.id.user_image_right);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        this.msgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Msg msg = msgList.get(position);

        if (msg.getType() == Msg.TYPE_RECEIVED){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.LEFT;
            holder.smgContent.setLayoutParams(lp);
            holder.smgContent.setBackgroundResource(R.drawable.message_left);
            holder.smgContent.setText(msg.getContent());
            holder.imageLeft.setVisibility(View.VISIBLE);
            holder.imageRight.setVisibility(View.INVISIBLE);
        }else{
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.RIGHT;
            holder.smgContent.setLayoutParams(lp);
            holder.smgContent.setBackgroundResource(R.drawable.message_right);
            holder.smgContent.setText(msg.getContent());
            holder.imageLeft.setVisibility(View.INVISIBLE);
            holder.imageRight.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount(){
        return msgList.size();
    }
}
