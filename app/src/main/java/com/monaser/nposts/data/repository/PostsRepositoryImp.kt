package com.monaser.nposts.data.repository

import com.monaser.nposts.data.remote.mapper.toPost
import com.monaser.nposts.data.remote.network.ApiService
import com.monaser.nposts.domain.entity.Post
import com.monaser.nposts.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryImp  @Inject constructor(
    private val apiService: ApiService
): BaseRepository(), PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return wrap { apiService.getPosts() }.map { it.toPost() }
    }

    override suspend fun getPost(postId: Int): Post {
        return wrap { apiService.getPostById(postId) }.toPost()
    }


}