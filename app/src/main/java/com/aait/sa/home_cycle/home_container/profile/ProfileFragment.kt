package com.aait.sa.home_cycle.home_container.profile

import androidx.fragment.app.viewModels
import com.aait.sa.base.BaseFragment
import com.aait.sa.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override val viewModel by viewModels<ProfileViewModel>()

    override fun onCreateView() {
        TODO("Not yet implemented")
    }
}