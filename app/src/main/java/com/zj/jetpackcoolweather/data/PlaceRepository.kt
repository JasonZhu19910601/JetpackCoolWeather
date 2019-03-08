package com.zj.jetpackcoolweather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zj.jetpackcoolweather.data.db.PlaceDao
import com.zj.jetpackcoolweather.data.model.place.City
import com.zj.jetpackcoolweather.data.model.place.Country
import com.zj.jetpackcoolweather.data.model.place.Province
import com.zj.jetpackcoolweather.data.network.CoolWeatherNetwork
import com.zj.jetpackcoolweather.util.CoolWeatherExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @package com.zj.jetpackcoolweather.data
 * @fileName PlaceRepository
 * @date 2019/3/8 14:51
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
class PlaceRepository private constructor(val placeDao: PlaceDao, private val network: CoolWeatherNetwork) {

    fun getProvinceList(): LiveData<Resource<List<Province>>> {
        val liveData = MutableLiveData<Resource<List<Province>>>()
        liveData.value = Resource.loading(null)
        CoolWeatherExecutors.diskIO.execute {
            val provinceList = placeDao.getProvinceList()
            if (provinceList.isEmpty()) {
                network.fetchProvinceList(object : Callback<List<Province>> {
                    override fun onResponse(call: Call<List<Province>>, response: Response<List<Province>>) {
                        CoolWeatherExecutors.diskIO.execute {
                            val result = response.body()
                            placeDao.saveProvinceList(result)
                            liveData.postValue(Resource.success(result))
                        }
                    }

                    override fun onFailure(call: Call<List<Province>>, t: Throwable) {
                        t.printStackTrace()
                        liveData.postValue(Resource.error("加载失败", null))
                    }
                })
            } else {
                liveData.postValue(Resource.success(provinceList))
            }
        }
        return liveData
    }

    fun getCityList(provinceId: Int): LiveData<Resource<List<City>>> {
        val liveData = MutableLiveData<Resource<List<City>>>()
        liveData.value = Resource.loading(null)
        CoolWeatherExecutors.diskIO.execute {
            val cityList = placeDao.getCityList(provinceId)
            if (cityList.isEmpty()) {
                network.fetchCityList(provinceId, object : Callback<List<City>> {
                    override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
                        CoolWeatherExecutors.diskIO.execute {
                            val result = response.body()
                            result?.forEach { it.provinceId = provinceId }
                            placeDao.saveCityList(result)
                            liveData.postValue(Resource.success(result))
                        }
                    }

                    override fun onFailure(call: Call<List<City>>, t: Throwable) {
                        t.printStackTrace()
                        liveData.postValue(Resource.error("加载失败", null))
                    }

                })
            } else {
                liveData.postValue(Resource.success(cityList))
            }
        }
        return liveData
    }

    fun getCountryList(provinceId: Int, cityId: Int): LiveData<Resource<List<Country>>> {
        val liveData = MutableLiveData<Resource<List<Country>>>()
        liveData.postValue(Resource.loading(null))
        CoolWeatherExecutors.diskIO.execute {
            val countryList = placeDao.getCountryList(cityId)
            if (countryList.isEmpty()) {
                network.fetchCountryList(provinceId, cityId, object : Callback<List<Country>> {
                    override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                        t.printStackTrace()
                        liveData.postValue(Resource.error("加载失败", null))
                    }

                    override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                        CoolWeatherExecutors.diskIO.execute {
                            val result = response.body()
                            result?.forEach { it.cityId = cityId }
                            placeDao.saveCountryList(result)
                            liveData.postValue(Resource.success(result))
                        }
                    }

                })
            } else {
                liveData.postValue(Resource.success(countryList))
            }
        }
        return liveData
    }

    companion object {
        private var instance: PlaceRepository? = null
        fun getInstance(placeDao: PlaceDao, network: CoolWeatherNetwork): PlaceRepository {
            if (instance == null) {
                synchronized(PlaceRepository::class.java) {
                    if (instance == null) {
                        instance = PlaceRepository(placeDao, network)
                    }
                }
            }
            return instance!!
        }
    }

}