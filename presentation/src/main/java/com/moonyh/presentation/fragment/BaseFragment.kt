package com.moonyh.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.moonyh.domain.usecase.GetStationInfoByNameUseCaseImpl
import com.moonyh.presentation.custom.FullScreenProgress
import com.moonyh.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.collectLatest
import retrofit2.HttpException


abstract class BaseFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    protected val binding: T
        get() = _binding!!

    protected abstract val viewModel: BaseViewModel

//    protected val analyticsManager: AnalyticsManager by lazy {
//        AnalyticsManager.getInstance()
//    }

    protected val loadingView: FullScreenProgress by lazy {
        FullScreenProgress(requireContext()).apply { visibility = View.GONE }
    }

    protected abstract val viewBindingInflater: (
        inflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ) -> T

//    protected abstract val analyticsFragmentName: AnalyticsFragmentName


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = viewBindingInflater(inflater, container, false)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collectLatest {
                if (it)
                    setLoadingEnable()
                else
                    setLoadingDisable()
            }
        }

        val root = binding.root
        if (root is ViewGroup){
            root.addView(loadingView)

        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
//        if(analyticsFragmentName== AnalyticsFragmentName.SCREEN_NONE){
//            return
//        }
//        analyticsManager.debugLogScreen(analyticsFragmentName.koreaName,this::class.java.simpleName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val root=binding.root
        if(root is ViewGroup)
            root.removeView(loadingView)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun setLoadingEnable() {
        loadingView.visibility = View.VISIBLE
    }

    private fun setLoadingDisable() {
        loadingView.visibility = View.GONE
    }


}