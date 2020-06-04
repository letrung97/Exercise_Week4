package com.example.exercise_week4.database
import com.example.exercise_week4.activity.MainActivity
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("api_key", MainActivity.API_KEY).build()
        val finalRequest = request.newBuilder().url(url).build()
        return chain.proceed(finalRequest)
    }

}