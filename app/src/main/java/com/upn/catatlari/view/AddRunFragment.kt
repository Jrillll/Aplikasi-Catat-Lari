package com.upn.catatlari.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentAddRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel
import java.util.*

class AddRunFragment : Fragment() {

    private lateinit var binding: FragmentAddRunBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etDate.setOnClickListener {
            showDatePicker()
        }

        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString().trim()
            val km = binding.etDistanceKm.text.toString().trim()
            val m = binding.etDistanceM.text.toString().trim()
            val h = binding.etDurationH.text.toString().trim()
            val minutes = binding.etDurationM.text.toString().trim()

            if (runDate.isEmpty() || (km.isEmpty() && m.isEmpty()) || (h.isEmpty() && minutes.isEmpty())) {
                Toast.makeText(context, "Harap isi semua data lari!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val runInput = Run(
                    runDate = runDate,
                    runDistanceKm = if (km.isEmpty()) 0 else km.toInt(),
                    runDistanceM = if (m.isEmpty()) 0 else m.toInt(),
                    runDurationH = if (h.isEmpty()) 0 else h.toInt(),
                    runDurationM = if (minutes.isEmpty()) 0 else minutes.toInt()
                )

                runViewModel.addRun(runInput)
                Toast.makeText(context, "Data lari berhasil disimpan!", Toast.LENGTH_SHORT).show()
                
                // Navigate back to Home
                findNavController().navigateUp()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Input harus berupa angka!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                binding.etDate.setText(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}