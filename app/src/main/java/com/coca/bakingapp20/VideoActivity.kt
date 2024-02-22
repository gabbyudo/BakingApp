package com.coca.bakingapp20

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.coca.bakingapp20.databinding.ActivityVideoBinding

//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


class VideoActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null
    private var playWhenReady = true
    private var mediaItemIndex = 0
    private var playbackPosition = 0L

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val steps = intent?.getStringExtra(DetailDisplayActivity.BAKER)
        if (steps != null) {
            initializePlayer(steps)
        }
    }

    private fun initializePlayer(steps: String) {
        player = ExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                binding.videoView.player = exoPlayer
                val mediaItem = MediaItem.fromUri(steps)
                //exoPlayer.setMediaItem(mediaItem)
                exoPlayer.setMediaItems(listOf(mediaItem), mediaItemIndex, playbackPosition)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.prepare()
            }
    }

    override fun onStart() {
        super.onStart()
        val steps = intent?.getStringExtra(DetailDisplayActivity.BAKER)
        if (steps != null) {
            initializePlayer(steps)
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        val steps = intent?.getStringExtra(DetailDisplayActivity.BAKER)
        if ((SDK_INT <= 23 || player == null) && steps != null) {
            initializePlayer(steps)
        }
    }

    override fun onPause() {
        super.onPause()
        if (SDK_INT <= 23) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (SDK_INT > 23) {
            releasePlayer()
        }
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.videoView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            mediaItemIndex = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }

    companion object {
        const val BAKER = "extra_baking"
    }
}




