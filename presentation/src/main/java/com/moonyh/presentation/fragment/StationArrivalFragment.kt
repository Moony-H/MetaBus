package com.moonyh.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moonyh.presentation.databinding.FragmentStationArrivalBinding
import com.moonyh.presentation.viewmodel.BaseViewModel

class StationArrivalFragment:BaseFragment<FragmentStationArrivalBinding>(){

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStationArrivalBinding
        get() = FragmentStationArrivalBinding::inflate

    override val viewModel:

}