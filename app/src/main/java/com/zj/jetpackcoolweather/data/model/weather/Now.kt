package com.zj.jetpackcoolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * @package com.zj.jetpackcoolweather.data.model.weather
 * @fileName Now
 * @date 2019/3/8 11:16
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class Now {
    @SerializedName("tmp")
    var temperature = ""
    @SerializedName("cond")
    var more = ""

    inner class More {
        @SerializedName("txt")
        var info = ""
    }
}