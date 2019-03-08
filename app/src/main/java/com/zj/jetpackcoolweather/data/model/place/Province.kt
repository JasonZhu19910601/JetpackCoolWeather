package com.zj.jetpackcoolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * @package com.zj.jetpackcoolweather.data.model.place
 * @fileName Province
 * @date 2019/3/8 10:55
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
data class Province(@SerializedName("name") val provinceName: String, @SerializedName("id") val provinceCode: Int) :
    LitePalSupport() {
    @Transient
    val id = 0;
}