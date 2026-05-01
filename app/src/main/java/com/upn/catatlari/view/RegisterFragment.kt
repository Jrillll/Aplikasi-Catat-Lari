package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentRegisterBinding
import com.upn.catatlari.model.User
import com.upn.catatlari.viewmodel.AuthViewModel

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegister.setOnClickListener {
            val name = binding.etNameSignup.text.toString().trim()
            val email = binding.etEmailSignup.text.toString().trim()
            val password = binding.etPasswordSignup.text.toString()
            val retypePassword = binding.etRetypePasswordSignup.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || retypePassword.isEmpty()) {
                Toast.makeText(context, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != retypePassword) {
                Toast.makeText(context, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(email, name, password)
            authViewModel.register(user)
        }

        authViewModel.registerStatus.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(context, "Registrasi gagal. Email mungkin sudah terdaftar.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}