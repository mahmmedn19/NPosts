package com.monaser.nposts.presentation.posts

import com.monaser.nposts.domain.entity.Post

data class PostsUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val title: String?=null,
    val body: String?=null,
    val id: Int=0,
    val data: List<PostUiState> = emptyList()
)
data class PostUiState(
    val userId: Int=0,
    val id: Int=0,
    val title: String?=null,
    val body: String?=null
)

fun Post.toPostUiState() = PostUiState(
    userId = userId,
    id = id,
    title = title,
    body = body
)