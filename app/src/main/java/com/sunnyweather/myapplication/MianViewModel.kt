package com.sunnyweather.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @author wenji.zhao
 * @time 2023/05/26 10:15 上午
 * @email wj.zhao08@zuche.com
 * @desc
 */
class MianViewModel : ViewModel() {
    val amount: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val seconds: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    var amountText: CharSequence?
        get() = amount.value.toString()
        set(value) {
            amount.value = value.toString().toDoubleOrNull()
        }
    var secondsText: CharSequence?
        get() = seconds.value?.toInt().toString()
        set(value) {
            seconds.value = value.toString().toDoubleOrNull()
        }

    val amountFormatted: LiveData<String> =
        Transformations.map(amount) { String.format("%.2f", it) }

    val secondsFormatted: LiveData<String> =
        Transformations.map(seconds) {
            it?.toInt().toString()
        }

}