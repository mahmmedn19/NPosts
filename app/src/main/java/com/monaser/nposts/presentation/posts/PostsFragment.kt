package com.monaser.nposts.presentation.posts

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.monaser.nposts.R
import com.monaser.nposts.databinding.FragmentPostsBinding
import com.monaser.nposts.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.events.EventHandler
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostsFragment : BaseFragment<FragmentPostsBinding>() {

    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_posts
    override val viewModel: PostsViewModel by viewModels()
    private val postsAdapter: PostsAdapter by lazy { PostsAdapter(viewModel) }

    override fun setup() {
        initiateAdapter()
        collectAction()
    }

    private fun initiateAdapter() {
        binding.recyclerViewPosts.adapter = postsAdapter
    }

    private fun collectAction() {
        lifecycleScope.launch {
            viewModel.effect.collect { handleUiEffect(it) }
        }
    }
    private fun handleUiEffect(effect: PostUiEffect) {
        when (effect) {
            is PostUiEffect.ClickPostEffect -> {
                val action = PostsFragmentDirections.actionPostsFragmentToPostDetailsFragment(effect.id)
                findNavController().navigate(action)
            }
            else -> {}
        }
    }

}