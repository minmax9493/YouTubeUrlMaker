package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import com.example.android.youtubeurlmaker.R

/**
 * Created by murodjon on 2020/03/17
 */
//private val messageList = listOf()
////    ErrorMessageData("MESSAGE_INVALID_CREDENTIAL", R.string.invalid_credential),
////    ErrorMessageData("MESSAGE_NOT_CONFIRMED", R.string.confirm_email),
////    ErrorMessageData("VALIDATION_FAILED", R.string.validation_failed),
////    ErrorMessageData("PASSWORD_INCORRECT", R.string.password_incorrect),
////    ErrorMessageData("MESSAGE_INTERNAL_SERVER_ERROR", R.string.internel_server_error),
////    ErrorMessageData("MESSAGE_USER_NOT_FOUND", R.string.user_not_found)
////)
//
//fun String?.getMessageFromMsgCode():Int = messageList.firstOrNull{it.code == this}?.message?:R.string.unknown_message

data class ErrorMessageData(
    val code:String,
    val message:Int
)