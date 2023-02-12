package com.moonyh.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.moonyh.presentation.adapter.BusNumberAdapter
import com.moonyh.presentation.adapter.SelectedBusNumberAdapter
import com.moonyh.presentation.databinding.FragmentBusNumberSearchBinding
import com.moonyh.presentation.viewmodel.BusNumberSearchViewModel
import com.moonyh.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class BusNumberSearchFragment : BaseFragment<FragmentBusNumberSearchBinding>() {

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBusNumberSearchBinding
        get() = FragmentBusNumberSearchBinding::inflate

    override val viewModel: BusNumberSearchViewModel by viewModels()
    private val mainViewMode: MainViewModel by viewModels(ownerProducer = { requireActivity() })

    private val busNumberAdapter: BusNumberAdapter by lazy {
        BusNumberAdapter {
            mainViewMode.addSelectedBus(it)
        }
    }

    private val selectedBusNumberAdapter:SelectedBusNumberAdapter by lazy {
        SelectedBusNumberAdapter{
            mainViewMode.removeSelectedBus(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.searchedBusList.collectLatest {
                if (it.isEmpty())
                    return@collectLatest
                busNumberAdapter.submitList(it)

            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewMode.selectedBusInfoList.collectLatest {
                Log.e("test","bus id collected")
                selectedBusNumberAdapter.submitList(ArrayList(it.values))
            }
        }

        binding.listBus.adapter=busNumberAdapter
        binding.listBus.layoutManager=LinearLayoutManager(requireContext()).apply {
            orientation=LinearLayoutManager.VERTICAL
        }

        binding.listSelectedBus.adapter=selectedBusNumberAdapter
        binding.listSelectedBus.layoutManager=LinearLayoutManager(requireContext()).apply {
            orientation=LinearLayoutManager.HORIZONTAL
        }

        binding.btnNext.setOnClickListener {
            val action=BusNumberSearchFragmentDirections.actionBusNumberSearchFragmentToStationArrivalFragment()
            findNavController().navigate(action)

        }

        viewModel.getBusInStation(mainViewMode.cityCode,mainViewMode.stationId)


        return binding.root
    }
}