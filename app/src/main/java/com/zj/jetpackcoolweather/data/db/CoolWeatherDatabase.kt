package com.zj.jetpackcoolweather.data.db

/**
 * @package com.zj.jetpackcoolweather.data.db
 * @fileName CoolWeatherDatabase
 * @date 2019/3/8 13:35
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
object CoolWeatherDatabase {
    private var placeDao: PlaceDao? = null

    private var weatherDao: WeatherDao? = null

    fun getPlaceDao(): PlaceDao {
        if (placeDao == null) {
            placeDao = PlaceDao()
        }
        return placeDao!!
    }

    fun getWeatherDao(): WeatherDao {
        if (weatherDao == null) {
            weatherDao = WeatherDao()
        }
        return weatherDao!!
    }
}