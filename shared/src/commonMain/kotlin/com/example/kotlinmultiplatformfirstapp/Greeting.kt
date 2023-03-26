package com.example.kotlinmultiplatformfirstapp

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = getPlatform()

    // KtorのHttpClientを作成するためのコード
    private val httpClient = HttpClient {
        // ContentNegotiationプラグインは、HTTPリクエストのAcceptヘッダーを自動的に設定するために使用される。
        install(ContentNegotiation) {
            json(Json {
                // Jsonの整形
                prettyPrint = true
                // Jsonの構文が不正確でもエラーをスローしない
                isLenient = true
                // 未知のプロパティを無視
                ignoreUnknownKeys = true
            })
        }
    }

    // Exceptionクラスのインスタンスをスローする可能性があることを明示
    @Throws(Exception::class)
    suspend fun greet(): String {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last {it.launchSuccess == true}
        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThere are only ${daysUntilNewYear()} left until New Year! 🎆" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"
    }
}