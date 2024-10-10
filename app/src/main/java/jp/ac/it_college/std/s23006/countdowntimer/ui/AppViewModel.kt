package jp.ac.it_college.std.s23006.countdowntimer.ui

import androidx.lifecycle.ViewModel
import jp.ac.it_college.std.s23006.countdowntimer.logic.MyCountDownTimer

class AppViewModel : ViewModel() {
    var uiState = AppUiState()
        private set
    var timer: MyCountDownTimer? = null

    fun startTimer(millisInFuture: Long) {
        uiState.time.value = millisInFuture
        uiState.isRunning.value = true
        timer = MyCountDownTimer(millisInFuture = millisInFuture,
            countDownInterval = 100L,
            changed = { millisUntilFinished ->
                uiState.time.value = millisInFuture
                uiState.timeLeft.value = millisUntilFinished
                uiState.isRunning.value = true
            },
            finished = {
                uiState.time.value = millisInFuture
                uiState.timeLeft.value = 0
                uiState.isRunning.value = false
            })
        timer?.start()
    }

    fun stopTimer() {
        timer?.cancel()
        uiState.time.value = 3 * 60 * 1000
        uiState.timeLeft.value = 3 * 60 * 1000
        uiState.isRunning.value = false
    }

    fun addTime(second: Int) {
        if (!uiState.isRunning.value) {
            val newTime = uiState.time.value + second * 1000L
            uiState.time.value = newTime
            uiState.timeLeft.value = newTime
            uiState.isRunning.value = false
        }
    }
}