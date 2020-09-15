package com.jgarcia.presentation.view.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.jgarcia.presentation.view.fragments.ARG_OBJECT
import com.jgarcia.presentation.view.fragments.ImageContainerFragment

class ImagesCollectionPagerAdapter(
    private val images: List<String>,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        val imageContainer = ImageContainerFragment()
        imageContainer.arguments = Bundle().apply {
            putString(ARG_OBJECT, images[position])
        }
        return imageContainer
    }

    override fun getCount(): Int = images.size
}