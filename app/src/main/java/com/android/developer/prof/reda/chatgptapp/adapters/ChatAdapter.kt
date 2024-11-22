package com.android.developer.prof.reda.chatgptapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.developer.prof.reda.chatgptapp.databinding.ItemReceiverBinding
import com.android.developer.prof.reda.chatgptapp.databinding.ItemSenderBinding
import com.android.developer.prof.reda.chatgptapp.models.Chat
import java.text.SimpleDateFormat
import java.util.Locale

class ChatAdapter: ListAdapter<Chat, RecyclerView.ViewHolder>(DiffCallback) {

    class SenderViewHolder(private val senderBinding: ItemSenderBinding): ViewHolder(senderBinding.root){

        fun bind(itemSender: Chat){
            senderBinding.messageTv.text = itemSender.message
            val dateFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm a", Locale.getDefault())
            senderBinding.sendDateTv.text = dateFormat.format(itemSender.date)
        }

    }

    class ReceiverViewHolder(private val receiverBinding: ItemReceiverBinding): ViewHolder(receiverBinding.root){

        fun bind(itemSender: Chat){
            receiverBinding.messageTv.text = itemSender.message
            val dateFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm a", Locale.getDefault())
            receiverBinding.receiveDateTv.text = dateFormat.format(itemSender.date)
        }

    }
    companion object DiffCallback: DiffUtil.ItemCallback<Chat>(){
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem.chatId == newItem.chatId
        }

        override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1){ //Receiving Item
            ReceiverViewHolder(
                ItemReceiverBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }else{
            SenderViewHolder(
                ItemSenderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).messageType.equals("sender",true)){
            0   //Sender Item
        }else {
            1   //Receiver Item
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = getItem(position)

        if (chat.messageType.equals("sender", true)){
            (holder as SenderViewHolder).bind(chat)
        }else {
            (holder as ReceiverViewHolder).bind(chat)
        }
    }
}