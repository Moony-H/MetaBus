package com.moonyh.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.moonyh.presentation.databinding.FragmentSearchBinding
import com.moonyh.presentation.viewmodel.SearchViewModel
import com.moonyh.data.common.Key
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override val viewModel: SearchViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.cities.collectLatest {
                Log.e("test", "called")
                if (it == null)
                    return@collectLatest
                Log.e("test", "$it")
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.errorMessageFlow.collectLatest {
                if (it == "")
                    return@collectLatest
                Log.e("test", "error: ${it}")
            }
        }



        viewModel.getCities(requireContext())


        return binding.root
    }
}