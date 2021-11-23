package com.bugs.myrecyclermvvm2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val list = MutableLiveData<ArrayList<Sampel>>()
    val newList = arrayListOf<Sampel>()

    fun add(sampel: Sampel){
        newList.add(sampel)
        list.value = newList
    }

    fun remove(sampel: Sampel) {
        newList.remove(sampel)
        list.value = newList
    }


}