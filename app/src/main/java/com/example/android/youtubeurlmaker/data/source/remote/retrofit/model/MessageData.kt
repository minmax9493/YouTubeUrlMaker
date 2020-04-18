package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import android.content.Context
import androidx.annotation.IdRes

/**
 * Created by murodjon on 2020/03/17
 */

sealed class MessageData {

    internal class Resource internal constructor(@IdRes val res: Int) : MessageData()
    internal class Message internal constructor(val message: String) : MessageData()
    internal class Failure internal constructor(val exception: Throwable) : MessageData()

    fun isMessage() = this is Message
    fun isResource() = this is Resource
    fun isFailure() = this is Failure

    fun getMessageOrNull(): String? = (this as? Message)?.message
    fun getResourceOrNull(): Int? = (this as? Resource)?.res
    fun getFailureOrNull(): Throwable? = (this as? Failure)?.exception

    fun onMessage(f: (String) -> Unit): MessageData {
        if (isMessage()) getMessageOrNull()?.let { f(it) }
        return this
    }

    fun onResource(f: (Int) -> Unit): MessageData {
        if (isResource()) getResourceOrNull()?.let { f(it) }
        return this
    }

    fun onFailure(f: (Throwable) -> Unit): MessageData {
        if (isFailure()) getFailureOrNull()?.let { f(it) }
        return this
    }

    fun onResult(f: (Int?, String?, Throwable?, Any?) -> Unit): MessageData =
        onMessage { f(null, it, null, null) }.onResource { f(it, null, null, null) }.onFailure { f(null, null, it, null) }

    fun onResultMessage(context: Context, f: (String) -> Unit): MessageData =
        onMessage { f(it) }.onResource { f(context.getString(it)) }.onFailure { f(it.message.toString()) }

    companion object {
        fun message(message: String): MessageData = Message(message)
        fun resource(@IdRes res: Int): MessageData = Resource(res)
        fun failure(exception: Throwable): MessageData = Failure(exception)
    }
}