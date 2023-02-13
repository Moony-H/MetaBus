package com.moonyh.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moonyh.presentation.adapter.StationArrivalAdapter
import com.moonyh.presentation.databinding.FragmentStationArrivalBinding
import com.moonyh.presentation.viewmodel.BaseViewModel
import com.moonyh.presentation.viewmodel.MainViewModel
import com.moonyh.presentation.viewmodel.StationArrivalViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class StationArrivalFragment:BaseFragment<FragmentStationArrivalBinding>(){

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStationArrivalBinding
        get() = FragmentStationArrivalBinding::inflate

    override val viewModel: StationArrivalViewModel by viewModels()
    private val mainViewModel:MainViewModel by viewModels (ownerProducer = {requireActivity()})

    private val adapter:StationArrivalAdapter by lazy {
        StationArrivalAdapter{

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.list.adapter=adapter
        binding.list.layoutManager=LinearLayoutManager(requireContext()).apply {
            orientation=LinearLayoutManager.VERTICAL
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stationArrivalInfo.collectLatest {
                if(it.isEmpty())
                    return@collectLatest
                adapter.submitList(it)
            }
        }

        viewModel.startGettingArrivalInfo(mainViewModel.cityCode,mainViewModel.stationId)



        return binding.root
    }

}