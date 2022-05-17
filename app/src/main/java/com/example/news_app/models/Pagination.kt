package com.example.news_app.models

data class Pagination(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val total: Int
)