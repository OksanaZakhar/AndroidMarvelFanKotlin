package com.ksusha.vel.marvelfank.data.remotedata.servise

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class ParamsResponseKye {
    val API_KEY = "58d04bd91489ba9a35600b375dd3ba32"
    private val PRIVATE_KEY = "71db9e17f07154c68c48896972e85d0c013cc5e1"

    fun getTimestamp(): String {
        return System.currentTimeMillis().toString()
    }

    fun getHash(): String {
        val input = getTimestamp() + PRIVATE_KEY + API_KEY
        return getMd5(input)
    }

    private fun getMd5(input: String): String {
        return try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }


}