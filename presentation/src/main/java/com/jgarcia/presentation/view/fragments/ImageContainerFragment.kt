package com.jgarcia.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jgarcia.presentation.databinding.ImageContainerFragmentBinding
import com.jgarcia.presentation.util.loadImageFromPath

const val ARG_OBJECT = "img_url"

class ImageContainerFragment : Fragment() {

    private lateinit var binding: ImageContainerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ImageContainerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val imageUrl = getString(ARG_OBJECT)
            context?.let {
                imageUrl?.let { binding.imageContainer.loadImageFromPath(it) }
            }
        }
    }
}