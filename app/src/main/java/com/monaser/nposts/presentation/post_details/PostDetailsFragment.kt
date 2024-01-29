package com.monaser.nposts.presentation.post_details

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.monaser.nposts.R
import com.monaser.nposts.databinding.FragmentPostDetailsBinding
import com.monaser.nposts.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailsFragment : BaseFragment<FragmentPostDetailsBinding>() {

    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_post_details
    override val viewModel: PostsDetailsViewModel by viewModels()

    override fun setup() {
        val args: PostDetailsFragmentArgs by navArgs()
        val postId = args.id
        lifecycleScope.launch {
            viewModel.getPostById(postId)
        }
    }
}