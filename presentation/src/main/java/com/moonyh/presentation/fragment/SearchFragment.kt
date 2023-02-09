package com.moonyh.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moonyh.presentation.databinding.FragmentSearchBinding
import com.moonyh.presentation.viewmodel.SearchViewModel
import com.moonyh.data.common.Key
import com.moonyh.domain.model.CityInfo
import com.moonyh.presentation.adapter.CitySearchAdapter
import com.moonyh.presentation.algorithm.BoyerMooreTextSearch
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override val viewModel: SearchViewModel by viewModels()


    private val adapter:CitySearchAdapter by lazy {
        CitySearchAdapter()
    }

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
                Log.e("test", "${it.items}")
                adapter.submitList(it.items as List<CityInfo>?)

            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.errorMessageFlow.collectLatest {
                if (it == "")
                    return@collectLatest
                Log.e("test", "error: ${it}")
            }
        }

        binding.searchViewEditText.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text=s.toString()
                viewModel.cities.value?.let {body->
                    body.items.forEach {

                        BoyerMooreTextSearch.search(text,it.cityName)
                    }

                }

            }
        })

        binding.list.adapter=adapter
        binding.list.layoutManager=LinearLayoutManager(requireContext()).apply {
            orientation=LinearLayoutManager.VERTICAL
        }



        viewModel.getCities(requireContext())


        return binding.root
    }
}