package com.example.rvlopez.eventbusdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rvlopez.eventbusdemo.R;

import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder> {

    private List<String> messageList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView item;

        ViewHolder(View v) {
            super(v);
            item = (TextView) v.findViewById(R.id.item);
        }
    }

    public MessageListAdapter(List<String> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MessageListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item.setText(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
