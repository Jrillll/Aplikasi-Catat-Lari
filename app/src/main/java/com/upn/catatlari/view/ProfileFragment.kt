package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.upn.catatlari.databinding.FragmentProfileBinding
import com.upn.catatlari.model.User
import com.upn.catatlari.viewmodel.AuthViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var authViewModel: AuthViewModel
    private var currentUser: User? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        // Ambil data user dari MainActivity
        currentUser = (activity as? MainActivity)?.user

        // Tampilkan data user
        currentUser?.let {
            binding.etUsername.setText(it.name)
            binding.etEmail.setText(it.email)
            binding.etPassword.setText(it.password)
        }

        binding.btnUpdateProfile.setOnClickListener {
            val newName = binding.etUsername.text.toString()
            val newPassword = binding.etPassword.text.toString()
            val email = binding.etEmail.text.toString()

            if (newName.isNotEmpty() && newPassword.isNotEmpty()) {
                val updatedUser = User(email, newName, newPassword)
                authViewModel.update(updatedUser)
            } else {
                Toast.makeText(requireContext(), "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDeleteAccount.setOnClickListener {
            showDeleteConfirmDialog()
        }

        authViewModel.updateStatus.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Profil berhasil diperbarui", Toast.LENGTH_SHORT).show()
                // Update user di MainActivity agar data tetap sinkron
                val updatedUser = User(
                    binding.etEmail.text.toString(),
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString()
                )
                (activity as? MainActivity)?.user = updatedUser
            } else {
                Toast.makeText(requireContext(), "Gagal memperbarui profil", Toast.LENGTH_SHORT).show()
            }
        }

        authViewModel.deleteStatus.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Akun berhasil dihapus", Toast.LENGTH_SHORT).show()
                requireActivity().finish() // Keluar dari aplikasi setelah hapus akun
            } else {
                Toast.makeText(requireContext(), "Gagal menghapus akun", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogout.setOnClickListener { requireActivity().finish() }

        return binding.root
    }

    private fun showDeleteConfirmDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Hapus Akun")
            .setMessage("Apakah Anda yakin ingin menghapus akun ini? Semua data akan hilang.")
            .setPositiveButton("Hapus") { _, _ ->
                currentUser?.let { authViewModel.delete(it) }
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}