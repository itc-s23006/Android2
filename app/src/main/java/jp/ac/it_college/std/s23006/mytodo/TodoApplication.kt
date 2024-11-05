package jp.ac.it_college.std.s23006.mytodo

import android.app.Application
import jp.ac.it_college.std.s23006.mytodo.data.AppContainer
import jp.ac.it_college.std.s23006.mytodo.data.AppDataContainer

class TodoApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}