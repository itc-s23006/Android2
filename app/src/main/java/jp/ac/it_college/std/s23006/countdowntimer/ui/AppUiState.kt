package jp.ac.it_college.std.s23006.countdowntimer.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf

data class AppUiState(
    var time: MutableState<Long> = mutableLongStateOf(3 * 60 * 10000),
    var timeLeft: MutableState<Long> = mutableLongStateOf(time.value),
    var isRunning: MutableState<Boolean> = mutableStateOf(false)
)
