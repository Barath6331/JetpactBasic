package com.loyltworks.myapplication.dialog

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DialogViewModel: ViewModel() {

    val dialoger= Dialoger()

    fun showDialog(){
        viewModelScope.launch {
            val result  = dialoger.show()

            if(result == "Positive"){
                TODO()
            }
            Log.d("dsafsdf",""+result)
        }
    }
}