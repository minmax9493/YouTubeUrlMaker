package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.StringRes

/**
 * Created by murodjon on 2020/03/17
 */
sealed class NetworkData<T> {
    internal class Resource<T> internal constructor(@IdRes val res: Int) : NetworkData<T>()
    internal class Message<T> internal constructor(val message: String) : NetworkData<T>()
    internal class Failure<T> internal constructor(val exception: Throwable) : NetworkData<T>()
    internal class Data<T> internal constructor(val data: T) : NetworkData<T>()

    fun isMessage() = this is Message
    fun isResource() = this is Resource
    fun isFailure() = this is Failure
    fun isData() = this is Data<*>

    fun getMessageOrNull(): String? = (this as? Message)?.message
    fun getResourceOrNull(): Int? = (this as? Resource)?.res
    fun getFailureOrNull(): Throwable? = (this as? Failure)?.exception
    fun getDataOrNull() = (this as? Data<T>)?.data

    fun onMessage(f: (String) -> Unit): NetworkData<T> {
        if (isMessage()) getMessageOrNull()?.let { f(it) }
        return this
    }

    fun onResource(f: (Int) -> Unit): NetworkData<T> {
        if (isResource()) getResourceOrNull()?.let { f(it) }
        return this
    }

    fun onFailure(f: (Throwable) -> Unit): NetworkData<T> {
        if (isFailure()) getFailureOrNull()?.let { f(it) }
        return this
    }

    fun onData(f: (T) -> Unit): NetworkData<T> {
        if (isData()) getDataOrNull()?.let { f(it) }
        return this
    }

    fun onMessageData(f: (MessageData) -> Unit): NetworkData<T> = onMessage { f(MessageData.message(it)) }.onResource { f(MessageData.resource(it)) }
        .onFailure { f(MessageData.failure(it)) }

    fun onResult(f: (Int?, String?, Throwable?, T?) -> Unit): NetworkData<T> =
        onMessage { f(null, it, null, null) }.onResource { f(it, null, null, null) }.onFailure { f(null, null, it, null) }.onData { f(null, null, null, it) }

    fun onResultMessage(context: Context, f: (String) -> Unit): NetworkData<T> =
        onMessage { f(it) }.onResource { f(context.getString(it)) }.onFailure { f(it.message.toString()) }

    companion object {
        fun <T> message(message: String): NetworkData<T> = Message(message)
        fun <T> resource(@StringRes res: Int): NetworkData<T> = Resource(res as Int)
        fun <T> failure(exception: Throwable): NetworkData<T> = Failure(exception)
        fun <T> data(data: T): NetworkData<T> = Data(data)
    }

    override fun toString(): String {
        val text = when{
            isData() -> getDataOrNull().toString()
            isFailure() -> getFailureOrNull().toString()
            isMessage() -> getMessageOrNull().toString()
            isResource() -> getResourceOrNull().toString()
            else -> "Unknown"
        }
        return text
    }

}