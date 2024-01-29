package com.monaser.nposts.presentation.posts

import com.monaser.nposts.domain.usecase.GetAllPosts
import com.monaser.nposts.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getAllPosts: GetAllPosts
) : BaseViewModel<PostsUiState, PostUiEffect>(PostsUiState()), PostsInteractionListener {
    override val TAG: String = this::class.java.simpleName
    init {
        getPosts()
    }
    private fun getPosts() {
        tryToExecute(
            { getAllPosts.getAllPosts().map { it.toPostUiState() } },
            ::onGetPostsSuccess,
            ::onGetPostsError,
        )
    }
    private fun onGetPostsSuccess(posts: List<PostUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                data = posts
            )
        }
        log("data fetched successfully: ${state.value.data}")
    }

    private fun onGetPostsError(throwable: Throwable) {
        _state.update { it.copy(isLoading = false, isError = true, errorMessage = throwable.message) }
        log("error fetching data")
    }
    override fun onPostClicked(id: Int) {
        effectActionExecutor(_effect, PostUiEffect.ClickPostEffect(id))
    }

}