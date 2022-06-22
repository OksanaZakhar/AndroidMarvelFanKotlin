package com.ksusha.vel.marvelfank.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ksusha.vel.marvelfank.data.remotedata.model.Result
import com.ksusha.vel.marvelfank.data.remotedata.repository.MarvelRepository
import java.security.NoSuchAlgorithmException

class MainActivityViewModel : ViewModel() {

    @Throws(NoSuchAlgorithmException::class)
    fun getAllMarvelHero(): MutableLiveData<MutableList<Result>> {
        return MarvelRepository().getMutableLiveDataMarvel()
    }
}