package com.jay.bottomsheetplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jay.bottomsheetplayer.databinding.ActivityMainBinding
import com.jay.bottomsheetplayer.util.DimensionConverter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val livePlayerBehavior: BottomSheetBehavior<View>? by lazy {
        BottomSheetBehavior.from(binding.livePlayerView.root)
    }

    private val bottomNavigationHeight: Int by lazy {
        DimensionConverter.toPx(56f)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        livePlayerBehavior?.state = BottomSheetBehavior.STATE_HIDDEN

        livePlayerBehavior?.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                binding.livePlayerView.liveHandle.alpha = 1f - slideOffset
                if (slideOffset >= 0) {
                    binding.bottomNavigation?.translationY = bottomNavigationHeight * slideOffset
                    binding.startLiveButton?.translationY = bottomNavigationHeight * slideOffset
                }

                binding.livePlayerView.liveCancel.isClickable = slideOffset != 1.0f
                binding.livePlayerView.liveHandle.isClickable = slideOffset != 1.0f
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
//                    BottomSheetBehavior.STATE_DRAGGING, BottomSheetBehavior.STATE_COLLAPSED -> viewModel().notifierManager.requestLoseLiveChatFocus()
                    else -> return
                }

            }
        })

        binding.livePlayerView.liveHandle.setOnClickListener {
            livePlayerBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
        }

        binding.livePlayerView.liveCancel.setOnClickListener {
            livePlayerBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
        }

        binding.startLiveButton.setOnClickListener {
            livePlayerBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}