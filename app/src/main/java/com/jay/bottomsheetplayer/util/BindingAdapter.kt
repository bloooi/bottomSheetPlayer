package com.jay.bottomsheetplayer.util

import android.net.Uri
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.jay.bottomsheetplayer.R


@BindingAdapter("imgUri")
fun SimpleDraweeView.bindImageUri(uri: String?) {
    uri?.let {
        val imageRequest: ImageRequest = ImageRequestBuilder
            .newBuilderWithSource(Uri.parse(uri))
            .setProgressiveRenderingEnabled(true)
            .setLocalThumbnailPreviewsEnabled(true)
            .setShouldDecodePrefetches(true)
            .build()


        val controller: DraweeController = Fresco.newDraweeControllerBuilder()
            .setImageRequest(imageRequest)
            .setOldController(this.controller)
            .setAutoPlayAnimations(false)
            .build()

        this.controller = controller
    }
}

@BindingAdapter("circleImage")
fun SimpleDraweeView.circle(isCircle: Boolean?){
    val roundingParams = RoundingParams()
    roundingParams.roundAsCircle = isCircle ?: false

    if (isCircle == null || isCircle == false){
        roundingParams.setCornersRadius(DimensionConverter.toPx(10f).toFloat())
        this.hierarchy.setOverlayImage(ResourcesCompat.getDrawable(this.context.resources, R.drawable.bg_default_overlay, null))
    }
    this.hierarchy.roundingParams = roundingParams


    if (isCircle == true) {
        this.setBackgroundResource(R.drawable.circle_avatar)
    }else {
        this.setBackgroundResource(R.drawable.bg_detail_default_artist)
    }
}