package com.zj.jetpackcoolweather.data.model.weather

/**
 * @package com.zj.jetpackcoolweather.data.model.weather
 * @fileName AQI
 * @date 2019/3/8 11:01
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class AQI {
    lateinit var city: AQICity

    inner class AQICity {
        var aqi = ""
        var pm25 = ""
    }
}