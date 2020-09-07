package com.jgarcia.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jgarcia.presentation.R
import com.jgarcia.presentation.databinding.FragmentSelectionBinding

class SelectionFragment : Fragment() {

    private lateinit var fragmentSelectionBinding: FragmentSelectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentSelectionBinding = FragmentSelectionBinding.inflate(inflater, container, false)
        return fragmentSelectionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        // listener to show productListFragment
        fragmentSelectionBinding.btnSearchProduct.setOnClickListener { findNavController().navigate(R.id.action_selectionFragment_to_productListFragment) }
        // listener to show categories
        fragmentSelectionBinding.btnViewCategories.setOnClickListener { findNavController().navigate(R.id.action_selectionFragment_to_categoryListFragment) }
    }
}