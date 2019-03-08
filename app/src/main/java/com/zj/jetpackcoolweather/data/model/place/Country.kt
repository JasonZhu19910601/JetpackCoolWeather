package com.zj.jetpackcoolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * @package com.zj.jetpackcoolweather.data.model.place
 * @fileName Country
 * @date 2019/3/8 10:52
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
data class Country(@SerializedName("name") val countryName: String, @SerializedName("weather_id") val weatherId: String) :
    LitePalSupport() {
    @Transient
    val id = 0
    var cityId = 0
}