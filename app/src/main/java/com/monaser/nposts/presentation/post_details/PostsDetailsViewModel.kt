package com.monaser.nposts.presentation.post_details

import com.monaser.nposts.domain.usecase.GetAllPosts
import com.monaser.nposts.presentation.base.BaseViewModel
import com.monaser.nposts.presentation.posts.PostUiState
import com.monaser.nposts.presentation.posts.PostsUiState
import com.monaser.nposts.presentation.posts.toPostUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PostsDetailsViewModel @Inject constructor(
    private val getAllPosts: GetAllPosts
) : BaseViewModel<PostsUiState, Int>(PostsUiState()) {
    override val TAG: String = this::class.java.simpleName

    fun getPostById(id: Int) {
        tryToExecute(
            { getAllPosts.getPost(id).toPostUiState()},
            ::onGetPostByIdSuccess,
            ::onGetPostByIdError,
        )
    }
    private fun onGetPostByIdSuccess(post: PostUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                title = post.title,
                body = post.body,
                id = post.id
            )
        }
        log("data fetched successfully: ${state.value.data}")
    }

    private fun onGetPostByIdError(throwable: Throwable) {
        _state.update { it.copy(isLoading = false, isError = true, errorMessage = throwable.message) }
        log("error fetching data")
    }

}