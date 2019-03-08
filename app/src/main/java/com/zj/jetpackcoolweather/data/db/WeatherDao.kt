package com.zj.jetpackcoolweather.data.db

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.zj.jetpackcoolweather.CoolWeatherApplication
import com.zj.jetpackcoolweather.data.model.weather.Weather

/**
 * @package com.zj.jetpackcoolweather.data.db
 * @fileName WeatherDao
 * @date 2019/3/8 11:34
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class WeatherDao {
    fun cacheWeatherInfo(weather: Weather?) {
        if (weather == null) {
            return
        }
        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context).edit {
            val weatherInfo = Gson().toJson(weather)
            putString("weather", weatherInfo)
        }
    }

    fun getCachedWeather(): Weather? {
        val weatherInfo = PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context)
            .getString("weather", null);
        if (weatherInfo != null) {
            return Gson().fromJson(weatherInfo, Weather::class.java)
        }
        return null
    }

    fun cacheBingPic(bingPic: String?) {
        if (bingPic == null) {
            return
        }

        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context).edit {
            putString("bing_pic", bingPic)
        }
    }

    fun getCachedBingPic(): String? = PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context)
        .getString("bing_pic", null)

    private fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        action(editor)
        editor.apply()
    }
}