package com.zj.jetpackcoolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * @package com.zj.jetpackcoolweather.data.model.place
 * @fileName City
 * @date 2019/3/8 10:44
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
data class City(@SerializedName("name") val cityName: String, @SerializedName("id") val cityCode: Int) :
    LitePalSupport() {
    @Transient
    val id = 0
    var provinceId = 0
}