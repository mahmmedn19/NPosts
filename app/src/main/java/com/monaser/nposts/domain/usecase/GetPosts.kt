package com.monaser.nposts.domain.usecase

import com.monaser.nposts.domain.entity.Post
import com.monaser.nposts.domain.repository.PostsRepository
import javax.inject.Inject

interface IGetAllPosts {
    suspend fun getAllPosts(): List<Post>
    suspend fun getPost(id: Int): Post
}
class GetAllPosts  @Inject constructor(
    private val postsRepository: PostsRepository,
):IGetAllPosts {

    override suspend fun getAllPosts(): List<Post> {
        return postsRepository.getPosts()
    }

    override suspend fun getPost(id: Int): Post {
        return postsRepository.getPost(id)
    }

}