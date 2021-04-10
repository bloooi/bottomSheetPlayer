package com.jay.bottomsheetplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jay.bottomsheetplayer.databinding.FragmentPlayerLiveBinding

class PlayerFragment: Fragment() {
    private var _binding: FragmentPlayerLiveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayerLiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}