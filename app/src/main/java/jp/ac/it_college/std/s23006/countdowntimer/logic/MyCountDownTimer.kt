package jp.ac.it_college.std.s23006.countdowntimer.logic

import android.os.CountDownTimer

class MyCountDownTimer(
    millisInFuture: Long,
    countDownInterval: Long,
    val changed: (Long) -> Unit,
    val finished: () -> Unit,
) : CountDownTimer(millisInFuture, countDownInterval) {
    override fun onTick(millisUntilFinished: Long) {
        changed(millisUntilFinished)
    }

    override fun onFinish() {
        finished()
    }

}