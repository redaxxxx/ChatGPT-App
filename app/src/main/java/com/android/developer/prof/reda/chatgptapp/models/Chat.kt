package com.android.developer.prof.reda.chatgptapp.models

import java.util.Date
data class Chat (
    val chatId: String,
    val message: String,
    val messageType: String,
    val date: Date
)