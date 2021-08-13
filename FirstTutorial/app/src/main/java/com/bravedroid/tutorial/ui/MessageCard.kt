package com.bravedroid.tutorial.ui

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bravedroid.tutorial.R
import com.bravedroid.tutorial.model.Message

//no need as theses 2 annotations below do the work, the composable already has a default param
//@Preview
//@Composable
//fun MessageCardPreview() {
//    MessageCard(Message("khabib", "Send me location !"))
//}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
)
@Composable
fun MessageCard(message: Message = Message("Khabib", "Send me location !")) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            modifier = Modifier
                .sizeIn(minWidth = 80.dp)
                .clip(RoundedCornerShape(10f))
                .border(1.5.dp, MaterialTheme.colors.primaryVariant),
            painter = painterResource(id = R.drawable.img_profil),
            contentDescription = "card sample picture",
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else Color(0xD7565479),
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = message.author,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.secondaryVariant,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
//                elevation = 4.dp,
                color = surfaceColor,
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 18.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    color= Color(0xACF7D6D6),
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}
