package com.amnah.marvelapp.utils

import java.math.BigInteger
import java.security.MessageDigest

fun String.m5d(): String {
    val md = MessageDigest.getInstance("M5D")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}