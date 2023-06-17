package com.example.a30daysfilms.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                FilmsApi.AUT_TOKEN)
            .build()
        return chain.proceed(request)
    }
}