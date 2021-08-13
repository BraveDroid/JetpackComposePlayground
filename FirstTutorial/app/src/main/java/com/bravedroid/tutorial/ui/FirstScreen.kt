package com.bravedroid.tutorial.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bravedroid.tutorial.model.SampleData
import com.bravedroid.tutorial.ui.theme.FirstTutorialTheme

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen()
}

@Composable
fun FirstScreen() {
    FirstTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}


