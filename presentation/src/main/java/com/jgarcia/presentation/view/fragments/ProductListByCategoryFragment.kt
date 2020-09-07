package com.jgarcia.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jgarcia.presentation.databinding.FragmentProductListByCategoryBinding

class ProductListByCategoryFragment : Fragment() {

    private lateinit var fragmentProductListByCategoryBinding: FragmentProductListByCategoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentProductListByCategoryBinding = FragmentProductListByCategoryBinding.inflate(inflater, container, false)
        return fragmentProductListByCategoryBinding.root
    }

}