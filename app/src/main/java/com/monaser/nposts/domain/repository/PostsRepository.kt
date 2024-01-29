package com.monaser.nposts.domain.repository

import com.monaser.nposts.domain.entity.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(postId: Int): Post
}