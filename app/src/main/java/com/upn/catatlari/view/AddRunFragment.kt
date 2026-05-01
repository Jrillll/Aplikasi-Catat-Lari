<<<<<<< HEAD
package com.upn.catatlari.view

import android.app.DatePickerDialog
=======
// app/src/main/java/com/upn/catatlari/view/AddRunFragment.kt
package com.upn.catatlari.view

>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import androidx.fragment.app.activityViewModels
=======
import androidx.fragment.app.viewModels
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentAddRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel
<<<<<<< HEAD
import java.util.*
=======
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e

class AddRunFragment : Fragment() {

    private lateinit var binding: FragmentAddRunBinding
<<<<<<< HEAD
    private val runViewModel: RunViewModel by activityViewModels()
=======
    // Gunakan viewModels() agar mengikuti siklus hidup Fragment/Activity
    private val runViewModel: RunViewModel by viewModels()
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

<<<<<<< HEAD
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
=======
        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString().trim()
            val runDurationStr = binding.etRunDuration.text.toString().trim()
            val runDistanceStr = binding.etRunDistance.text.toString().trim()

            // Validasi: Cek apakah ada field yang kosong
            if (runDate.isEmpty() || runDurationStr.isEmpty() || runDistanceStr.isEmpty()) {
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
                Toast.makeText(context, "Harap isi semua data lari!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val runInput = Run(
                    runDate = runDate,
<<<<<<< HEAD
                    runDistanceKm = if (km.isEmpty()) 0 else km.toInt(),
                    runDistanceM = if (m.isEmpty()) 0 else m.toInt(),
                    runDurationH = if (h.isEmpty()) 0 else h.toInt(),
                    runDurationM = if (minutes.isEmpty()) 0 else minutes.toInt()
=======
                    runDuration = runDurationStr.toInt(),
                    runDistance = runDistanceStr.toInt()
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
                )

                runViewModel.addRun(runInput)
                Toast.makeText(context, "Data lari berhasil disimpan!", Toast.LENGTH_SHORT).show()
<<<<<<< HEAD
                
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
=======
                findNavController().popBackStack()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Durasi dan Jarak harus berupa angka!", Toast.LENGTH_SHORT).show()
            }
        }
    }
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
}