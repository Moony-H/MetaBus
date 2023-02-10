package com.moonyh.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moonyh.presentation.adapter.StationSearchAdapter
import com.moonyh.presentation.databinding.FragmentSearchBinding
import com.moonyh.presentation.viewmodel.MainViewModel
import com.moonyh.presentation.viewmodel.StationSearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class StationSearchFragment:BaseFragment<FragmentSearchBinding>() {
    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override val viewModel: StationSearchViewModel by viewModels()

    private val mainViewModel:MainViewModel by viewModels(ownerProducer = {requireActivity()})

    private val adapter:StationSearchAdapter by lazy {
        StationSearchAdapter{
            mainViewModel.setStationId(it.id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.layoutTitle.text="정류소를 검색하세요"

        binding.list.adapter=adapter
        binding.list.layoutManager=LinearLayoutManager(requireContext()).apply {
            orientation=LinearLayoutManager.VERTICAL
        }
        binding.searchViewEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.getStation(mainViewModel.cityCode,s.toString())

            }
        })

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.searchedStation.collectLatest {
                adapter.submitList(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.errorMessageFlow.collectLatest {
                if(it=="")
                    return@collectLatest
                Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
                Log.e("test",it)
            }
        }

        return binding.root
    }

}