// app/src/main/java/com/upn/catatlari/viewmodel/RunViewModel.kt
package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.upn.catatlari.model.AppDatabase
import com.upn.catatlari.model.Run
import kotlinx.coroutines.launch

class RunViewModel(application: Application) : AndroidViewModel(application) {

    private val runDao = AppDatabase.getDatabase(application).runDao()

    // Ambil data lari dari Room dan ubah Flow menjadi LiveData agar bisa diobservasi di Fragment
    val runHistory: LiveData<List<Run>> = runDao.getAllRuns().asLiveData()

    // Fungsi CREATE untuk menyimpan ke Database
    fun addRun(run: Run) {
        viewModelScope.launch {
            runDao.insertRun(run)
        }
    }

    // Fungsi DELETE untuk menghapus dari Database
    fun deleteRun(run: Run) {
        viewModelScope.launch {
            runDao.deleteRun(run)
        }
    }
}