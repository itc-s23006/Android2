package jp.ac.it_college.std.s23006.order.ui

import android.widget.RadioButton
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonWithText(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onSelect: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .selectable(selected = selected, onClick = onSelect)
    ) {
        RadioButton(

        )
    }
}