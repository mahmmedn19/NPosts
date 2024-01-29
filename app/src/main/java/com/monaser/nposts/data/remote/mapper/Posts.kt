package com.monaser.nposts.data.remote.mapper

import com.monaser.nposts.data.remote.models.PostDTO
import com.monaser.nposts.domain.entity.Post

fun PostDTO.toPost(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}