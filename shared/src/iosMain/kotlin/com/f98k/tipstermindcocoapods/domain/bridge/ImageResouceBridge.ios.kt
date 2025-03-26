package com.f98k.tipstermindcocoapods.domain.bridge

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import org.jetbrains.skia.ColorAlphaType
import org.jetbrains.skia.ColorType
import org.jetbrains.skia.Image
import org.jetbrains.skia.ImageInfo
import platform.Foundation.NSData
import platform.UIKit.UIImage
import platform.UIKit.UIImagePNGRepresentation
import platform.posix.memcpy

@Composable
actual fun getImageResource(name: String): Painter {
    val uiImage: UIImage = UIImage.imageNamed(name) ?: return fallbackPainter()

    val imageData: NSData = UIImagePNGRepresentation(uiImage) ?: return fallbackPainter()

    val skiaImage = Image.makeFromEncoded(imageData.toByteArray())
    return BitmapPainter(skiaImage.toImageBitmapManual())
}

private fun fallbackPainter(): Painter {
    return makeFallbackPainter()
}

@OptIn(ExperimentalForeignApi::class)
private fun NSData.toByteArray(): ByteArray = ByteArray(this.length.toInt()).apply {
    usePinned {
        memcpy(it.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
    }
}

private fun Image.toImageBitmapManual(): ImageBitmap {
    val encoded = this.encodeToData() ?: error("Failed to encode Skia Image")
    val bytes = encoded.bytes
    return Image.makeFromEncoded(bytes).toComposeImageBitmap()
}

private fun makeFallbackPainter(): Painter {
    val imageInfo = ImageInfo(
        1, 1,
        ColorType.RGBA_8888,
        ColorAlphaType.UNPREMUL
    )

    val emptyBytes = ByteArray(4)
    val fallbackImage = Image.makeRaster(imageInfo, emptyBytes, 4)

    return BitmapPainter(fallbackImage.toImageBitmapManual())
}