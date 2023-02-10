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
import com.moonyh.presentation.viewmodel.CitySearchViewModel
import com.moonyh.presentation.adapter.CitySearchAdapter
import com.moonyh.presentation.databinding.FragmentSearchCityBinding
import com.moonyh.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CitySearchFragment : BaseFragment<FragmentSearchCityBinding>() {

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchCityBinding
        get() = FragmentSearchCityBinding::inflate

    override val viewModel: CitySearchViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels (ownerProducer = {requireActivity()})

    private val adapter:CitySearchAdapter by lazy {
        CitySearchAdapter{
            mainViewModel.setCityCode(it.cityCode)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.cities.collectLatest {
                adapter.submitList(it )
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.errorMessageFlow.collectLatest {
                if (it == "")
                    return@collectLatest
                Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
            }
        }

        binding.searchViewEditText.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text=s.toString()
                Log.e("test","text: $text")
                viewModel.searchCities(text)

            }
        })

        binding.list.adapter=adapter
        binding.list.layoutManager=LinearLayoutManager(requireContext()).apply {
            orientation=LinearLayoutManager.VERTICAL
        }

        viewModel.getCities()


        return binding.root
    }
}