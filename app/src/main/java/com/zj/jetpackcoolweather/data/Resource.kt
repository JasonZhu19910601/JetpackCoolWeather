package com.zj.jetpackcoolweather.data

/**
 * @package com.zj.jetpackcoolweather.data
 * @fileName Resource
 * @date 2019/3/8 14:52
 * @author Zj
 * @describe TODO
 * @org Leading.com(北京理正软件)
 * @email 2856211755@qq.com
 * @computer Administrator
 */
data class Resource<T>(val status: Int, val data: T?, val message: String?) {

    companion object {
        const val SUCCESS = 0
        const val ERROR = 1
        const val LOADING = 2

        fun <T> success(data: T?) = Resource(SUCCESS, data, null)

        fun <T> error(msg: String, data: T?) = Resource(ERROR, data, msg)

        fun <T> loading(data: T?) = Resource(LOADING, data, null)
    }

}