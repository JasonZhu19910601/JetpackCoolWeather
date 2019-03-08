package com.zj.jetpackcoolweather.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * @package com.zj.jetpackcoolweather.util
 * @fileName CoolWeatherExecutors
 * @date 2019/3/8 14:31
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
object CoolWeatherExecutors {

    val diskIO = Executors.newSingleThreadExecutor()

    val networkIO = Executors.newFixedThreadPool(3)

    val mainThread = MainThreadExecutor()

    class MainThreadExecutor : Executor {
        val handler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable?) {
            handler.post(command)
        }

    }

}