package com.monaser.nposts.domain.entity

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)