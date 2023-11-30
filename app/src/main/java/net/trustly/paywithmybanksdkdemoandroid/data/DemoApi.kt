package net.trustly.paywithmybanksdkdemoandroid.data

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface DemoApi {

    @POST("/signature")
    fun postSignature(@Body establishData: Map<String, String>): Observable<ResponseBody>

}