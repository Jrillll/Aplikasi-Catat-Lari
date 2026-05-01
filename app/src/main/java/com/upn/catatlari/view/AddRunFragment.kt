// app/src/main/java/com/upn/catatlari/view/AddRunFragment.kt
package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentAddRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel

class AddRunFragment : Fragment() {

    private lateinit var binding: FragmentAddRunBinding
    // Gunakan viewModels() agar mengikuti siklus hidup Fragment/Activity
    private val runViewModel: RunViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString().trim()
            val runDurationStr = binding.etRunDuration.text.toString().trim()
            val runDistanceStr = binding.etRunDistance.text.toString().trim()

            // Validasi: Cek apakah ada field yang kosong
            if (runDate.isEmpty() || runDurationStr.isEmpty() || runDistanceStr.isEmpty()) {
                Toast.makeText(context, "Harap isi semua data lari!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val runInput = Run(
                    runDate = runDate,
                    runDuration = runDurationStr.toInt(),
                    runDistance = runDistanceStr.toInt()
                )

                runViewModel.addRun(runInput)
                Toast.makeText(context, "Data lari berhasil disimpan!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Durasi dan Jarak harus berupa angka!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}