package com.example.kotlinmultiplatformfirstapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Serializableアノテーションをつけることで、kotlinx.serialisationプラグインが自動的にデフォルトのシリアライザーを生成してくれる
@Serializable
data class RocketLaunch (
    // データクラスのプロパティをより読みやすい名前で宣言できる
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("date_utc")
    val launchDateUTC: String,
    @SerialName("success")
    val launchSuccess: Boolean?,
)