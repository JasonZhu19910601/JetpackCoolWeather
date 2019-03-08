package com.zj.jetpackcoolweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import org.litepal.LitePal

/**
 * @package com.zj.jetpackcoolweather
 * @fileName CoolWeatherApplication
 * @date 2019/3/8 11:36
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class CoolWeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}