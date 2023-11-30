package net.trustly.paywithmybanksdkdemoandroid.data

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(): DemoApi {
        val client = OkHttpClient.Builder()
            .addInterceptor {
                val request: Request = it.request()
                    .newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .build()
                it.proceed(request)
            }
            .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://shop-on-merchant.fly.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!.create(DemoApi::class.java)
    }

}