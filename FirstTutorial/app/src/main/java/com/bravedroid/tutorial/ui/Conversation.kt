package com.bravedroid.tutorial.ui

import android.nfc.Tag
import android.util.Log
import android.util.Log.d
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bravedroid.tutorial.model.Message
import com.bravedroid.tutorial.model.SampleData
import com.bravedroid.tutorial.ui.theme.FirstTutorialTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
            logMessage(message)
        }
    }
}

private fun logMessage(message: Message) {
    Log.d("message_load","${message.author} is loaded ")
}

@Preview
@Composable
fun ConversationPreview1() {
         Conversation(SampleData.conversationSample)

}

@Preview
@Composable
fun ConversationPreview2() {
    FirstTutorialTheme {
         Conversation(SampleData.conversationSample)
    }
}
