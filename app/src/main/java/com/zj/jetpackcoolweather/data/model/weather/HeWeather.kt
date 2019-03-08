package com.zj.jetpackcoolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * @package com.zj.jetpackcoolweather.data.model.weather
 * @fileName HeWeather
 * @date 2019/3/8 11:15
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class HeWeather {
    @SerializedName("HeWeather")
    var weather: List<Weather>? = null
}