package com.zj.jetpackcoolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * @package com.zj.jetpackcoolweather.data.model.weather
 * @fileName Suggestion
 * @date 2019/3/8 11:22
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class Suggestion {
    @SerializedName("comf")
    lateinit var comfort: Comfort
    @SerializedName("cw")
    lateinit var carWash: CarWash
    lateinit var sport: Sport

    inner class Comfort {
        @SerializedName("txt")
        var info = ""
    }

    inner class CarWash {
        @SerializedName("txt")
        var info = ""
    }

    inner class Sport {
        @SerializedName("txt")
        var info = ""
    }
}