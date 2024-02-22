package com.coca.bakingapp20

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailDisplayViewModel : ViewModel() {

    private val _mySteps = MutableLiveData<List<Step>>()
    val mySteps: LiveData<List<Step>>
        get() = _mySteps

    fun getDescriptions(steps: List<Step>) {
        val descriptionsMap = steps
        _mySteps.value = descriptionsMap
    }
}