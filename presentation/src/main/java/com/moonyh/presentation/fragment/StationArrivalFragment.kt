package com.moonyh.presentation.fragment

import android.os.Bundle
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
import kotlinx.coroutines.flow.collectLatest

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
                adapter.submitList(it)
            }
        }



        return binding.root
    }

}