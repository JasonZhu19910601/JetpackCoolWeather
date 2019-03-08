package com.zj.jetpackcoolweather.data.db

import com.zj.jetpackcoolweather.data.model.place.City
import com.zj.jetpackcoolweather.data.model.place.Country
import com.zj.jetpackcoolweather.data.model.place.Province
import org.litepal.LitePal

/**
 * @package com.zj.jetpackcoolweather.data.db
 * @fileName PlaceDao
 * @date 2019/3/8 11:56
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class PlaceDao {
    fun getProvinceList(): MutableList<Province> = LitePal.findAll(Province::class.java)

    fun getCityList(provinceId: Int): MutableList<City> = LitePal
        .where("provinceId = ?", provinceId.toString()).find(City::class.java)

    fun getCountryList(cityId: Int): MutableList<Country> = LitePal
        .where("cityId = ?", cityId.toString()).find(Country::class.java)

    fun saveProvinceList(provinceList: List<Province>?) {
        if (provinceList != null && provinceList.isNotEmpty()) {
            LitePal.saveAll(provinceList)
        }
    }

    fun saveCityList(cityList: List<City>?) {
        if (cityList != null && cityList.isNotEmpty()) {
            LitePal.saveAll(cityList)
        }
    }

    fun saveCountryList(countryList: List<Country>?) {
        if (countryList != null && countryList.isNotEmpty()) {
            LitePal.saveAll(countryList)
        }
    }
}