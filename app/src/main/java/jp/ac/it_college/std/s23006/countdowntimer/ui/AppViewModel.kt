package jp.ac.it_college.std.s23006.countdowntimer.ui

import androidx.lifecycle.ViewModel
import jp.ac.it_college.std.s23006.countdowntimer.logic.MyCountDownTimer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

const val DEFAULT_TIME = 3 * 60 * 1000L

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState(time = DEFAULT_TIME))
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    private var timer: MyCountDownTimer? = null

    fun startTimer(millisInFuture: Long) {
        _uiState.update { currentState ->
            currentState.copy(
                time = millisInFuture,
                isRunning = true
            )
        }

        timer = MyCountDownTimer(
            millisInFuture = millisInFuture,
            countDownInterval = 100L,
            changed = { millisUntilFinished ->
                _uiState.update { currentState ->
                    currentState.copy(
                        time = millisInFuture,
                        timeLeft = millisUntilFinished,
                        isRunning = true
                    )
                }
            },
            finished = {
                _uiState.update { currentState ->
                    currentState.copy(
                        time = millisInFuture,
                        timeLeft = 0,
                        isRunning = false
                    )
                }
            })
        timer?.start()
    }

    fun stopTimer() {
        timer?.cancel()
        _uiState.update { currentState ->
            currentState.copy(
                time = DEFAULT_TIME,
                timeLeft = 3 * 60 * 1000,
                isRunning = false
            )
        }
    }

    fun addTime(second: Int) {
        if (!uiState.value.isRunning) {
            val newTime = uiState.value.time + second * 1000L
            _uiState.update {
                    currentState ->
                currentState.copy(
                    time = newTime,
                    timeLeft = newTime,
                    isRunning = false
                )
            }
        }
    }
}