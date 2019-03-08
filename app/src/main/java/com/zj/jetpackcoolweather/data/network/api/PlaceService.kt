package com.zj.jetpackcoolweather.data.network.api

import com.zj.jetpackcoolweather.data.model.place.City
import com.zj.jetpackcoolweather.data.model.place.Country
import com.zj.jetpackcoolweather.data.model.place.Province
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * @package com.zj.jetpackcoolweather.data.network
 * @fileName PlaceService
 * @date 2019/3/8 13:42
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
interface PlaceService {

    @GET("api/china")
    fun getProvinces(): Call<List<Province>>

    @GET("api/china/{provinceId}")
    fun getCities(@Path("provinceId") provinceId: Int): Call<List<City>>

    @GET("api/china/{provinceId}/{cityId}")
    fun getCounties(@Path("provinceId") provinceId: Int, @Path("cityId") cityId: Int): Call<List<Country>>
}