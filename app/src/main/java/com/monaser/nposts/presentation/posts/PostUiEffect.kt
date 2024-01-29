package com.monaser.nposts.presentation.posts

import com.monaser.nposts.presentation.base.BaseUiEffect

sealed interface PostUiEffect: BaseUiEffect {
    data class ClickPostEffect(val id: Int) : PostUiEffect
}