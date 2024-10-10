package jp.ac.it_college.std.s23006.countdowntimer.ui

data class AppUiState(
    var time: Long,
    var timeLeft: Long = time,
    var isRunning: Boolean = false
)
