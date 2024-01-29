package com.monaser.nposts.presentation.posts


import com.monaser.nposts.R
import com.monaser.nposts.presentation.base.BaseAdapter

class PostsAdapter(listener: PostsInteractionListener): BaseAdapter<PostsUiState>(listener) {
    override val layoutId: Int = R.layout.item_post
}
