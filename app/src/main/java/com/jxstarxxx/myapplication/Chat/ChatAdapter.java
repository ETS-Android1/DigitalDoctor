package com.jxstarxxx.myapplication.Chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.jxstarxxx.myapplication.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.thisViewHolder> {

    private List<Message> messageList;
    private FirebaseAuth auth;
    private final Context context;
    private String id;

    public ChatAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
        this.id = auth.getUid();
    }

    @NonNull
    @Override
    public ChatAdapter.thisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new thisViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_adapter_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.thisViewHolder holder, int position) {
        Message message = messageList.get(position);

        if (message.getSenderID().equals(id)) {
            holder.senderLayout.setVisibility(View.VISIBLE);
            holder.receiverLayout.setVisibility(View.GONE);
            holder.senderMessage.setText(message.getMessage());
            holder.senderTime.setText(message.getTime());
        }
        else {
            holder.senderLayout.setVisibility(View.GONE);
            holder.receiverLayout.setVisibility(View.VISIBLE);
            holder.receiverMessage.setText(message.getMessage());
            holder.receiverTime.setText(message.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public void update(List<Message> messageList) {
        this.messageList = messageList;
    }

    static class thisViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout receiverLayout, senderLayout;
        private TextView receiverMessage, senderMessage;
        private TextView receiverTime, senderTime;

        public thisViewHolder(@NonNull View itemView) {
            super(itemView);

            receiverLayout = itemView.findViewById(R.id.receiver_layout);
            senderLayout = itemView.findViewById(R.id.sender_layout);
            receiverMessage = itemView.findViewById(R.id.receiver_message);
            senderMessage  = itemView.findViewById(R.id.sender_message);
            receiverTime = itemView.findViewById(R.id.receiver_time);
            senderTime = itemView.findViewById(R.id.sender_time);
        }
    }
}
