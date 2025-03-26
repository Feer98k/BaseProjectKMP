package com.f98k.tipstermindcocoapods.domain.bridge
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.stringWithContentsOfFile
import platform.Foundation.NSUTF8StringEncoding

@OptIn(ExperimentalForeignApi::class)
actual fun readJsonFileFromAssets(fileName: String): String {
    val path = NSBundle.mainBundle.pathForResource(name = fileName.removeSuffix(".json"), ofType = "json")
    return path?.let {
        NSString.stringWithContentsOfFile(it, encoding = NSUTF8StringEncoding, error = null) as String
    } ?: ""
}