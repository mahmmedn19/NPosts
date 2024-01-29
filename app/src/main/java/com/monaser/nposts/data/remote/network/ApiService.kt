package com.monaser.nposts.data.remote.network

import com.monaser.nposts.data.remote.models.PostDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostDTO>>
    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId: Int): Response<PostDTO>

}