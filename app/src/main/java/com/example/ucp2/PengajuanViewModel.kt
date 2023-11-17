package com.example.ucp2

import androidx.lifecycle.ViewModel
import com.example.ucp2.ui.data.FormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


    class PengajuanViewModel: ViewModel(){
        private val _stateUI = MutableStateFlow(FormUiState)
        val stateUI: StateFlow<FormUiState> = _stateUI.asStateFlow()

        fun setContact(listContact: MutableList<String>){
            _stateUI.update { stateSaatIni ->
                stateSaatIni.copy(
                    nama = listContact[0],
                    nim = listContact[1],
                    konsentrasi = listContact[2],
                    judul = listContact[3]
                )
            }
        }
    }
    fun  setDosen(dosenPilihan: String){
        _stateUI.update {stateSaatIni ->
            stateSaatIni.copy(dosen = dosenPilihan)
        }
    }
    fun setDosen2(dosenPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen = dosenPilihan)
        }
    }
