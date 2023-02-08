package com.moonyh.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.moonyh.domain.usecase.GetStationInfoByNameUseCaseImpl
import com.moonyh.presentation.viewmodel.BaseViewModel
import retrofit2.HttpException


abstract class BaseFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    protected val binding: T
        get() = _binding!!

    protected abstract val viewModel:BaseViewModel

//    protected val analyticsManager: AnalyticsManager by lazy {
//        AnalyticsManager.getInstance()
//    }

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

        return binding.root
    }

    override fun onResume() {
        super.onResume()
//        if(analyticsFragmentName== AnalyticsFragmentName.SCREEN_NONE){
//            return
//        }
//        analyticsManager.debugLogScreen(analyticsFragmentName.koreaName,this::class.java.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}