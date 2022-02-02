package com.aait.sa.cycles.home_cycle.home_container

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.aait.sa.R
import com.aait.sa.base.BaseFragment
import com.aait.sa.databinding.FragmentHomeContainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeContainerFragment : BaseFragment<FragmentHomeContainerBinding>(FragmentHomeContainerBinding::inflate) {

    override val viewModel by viewModels<HomeContainerViewModel>()

    override fun onCreateView() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        val navController = Navigation.findNavController(requireActivity(), R.id.home_container)
        NavigationUI.setupWithNavController(binding.navView, navController)
        binding.navView.setupWithNavController(navController)
    }
}