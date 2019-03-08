package com.zj.jetpackcoolweather.data.network

import com.zj.jetpackcoolweather.data.model.place.City
import com.zj.jetpackcoolweather.data.model.place.Country
import com.zj.jetpackcoolweather.data.model.place.Province
import com.zj.jetpackcoolweather.data.model.weather.HeWeather
import com.zj.jetpackcoolweather.data.network.api.PlaceService
import com.zj.jetpackcoolweather.data.network.api.WeatherService
import retrofit2.Callback

/**
 * @package com.zj.jetpackcoolweather.data.network
 * @fileName CoolWeatherNetwork
 * @date 2019/3/8 14:00
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class CoolWeatherNetwork {

    private val placeService = ServiceCreator.create(PlaceService::class.java)

    private val weatherService = ServiceCreator.create(WeatherService::class.java)

    fun fetchProvinceList(callback: Callback<List<Province>>) = placeService.getProvinces().enqueue(callback)

    fun fetchCityList(provinceId: Int, callback: Callback<List<City>>) =
        placeService.getCities(provinceId).enqueue(callback)

    fun fetchCountryList(provinceId: Int, cityId: Int, callback: Callback<List<Country>>) =
        placeService.getCounties(provinceId, cityId).enqueue(callback)

    fun fetchWeather(weatherId: String, key: String, callback: Callback<HeWeather>) =
        weatherService.getWeather(weatherId, key).enqueue(callback)

    companion object {

        private var network: CoolWeatherNetwork? = null

        fun getInstance(): CoolWeatherNetwork {
            if (network == null) {
                synchronized(CoolWeatherNetwork::class.java) {
                    if (network == null) {
                        network = CoolWeatherNetwork()
                    }
                }
            }
            return network!!
        }
    }

}