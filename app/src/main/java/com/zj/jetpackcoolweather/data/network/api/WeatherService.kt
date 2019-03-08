package com.zj.jetpackcoolweather.data.network.api

import com.zj.jetpackcoolweather.data.model.weather.HeWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @package com.zj.jetpackcoolweather.data.network
 * @fileName WeatherService
 * @date 2019/3/8 13:49
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
interface WeatherService {

    @GET("api/weather")
    fun getWeather(@Query("cityid") weatherId: String, @Query("key") key: String): Call<HeWeather>

    @GET("api/bing_pic")
    fun getBingPck(): Call<String>

}