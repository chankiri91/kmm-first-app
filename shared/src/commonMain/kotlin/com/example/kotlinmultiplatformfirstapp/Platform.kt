package com.example.kotlinmultiplatformfirstapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform