package com.example.kotlinmultiplatformfirstapp

import kotlinx.datetime.*

fun daysUntilNewYear(): Int {
    // 現在の時付を取得
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    // 次の元旦を取得
    val closestNewYear = LocalDate(today.year + 1, 1, 1)
    // 元旦までの日数を計算、整数値を返す
    return today.daysUntil(closestNewYear)
}