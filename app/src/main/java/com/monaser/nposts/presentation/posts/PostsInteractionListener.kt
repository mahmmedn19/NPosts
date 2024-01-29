package com.monaser.nposts.presentation.posts

import com.monaser.nposts.presentation.base.BaseInteractionListener

interface PostsInteractionListener: BaseInteractionListener {
    fun onPostClicked(id: Int)
}