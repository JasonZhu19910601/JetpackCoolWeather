package com.zj.jetpackcoolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * @package com.zj.jetpackcoolweather.data.model.weather
 * @fileName Basic
 * @date 2019/3/8 11:03
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class Basic {
    @SerializedName("city")
    var city = ""
    @SerializedName("id")
    var weatherId = ""
    lateinit var update: Update

    inner class Update {
        @SerializedName("loc")
        var updateTime = ""
    }
}