package com.upn.catatlari.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.R
import com.upn.catatlari.databinding.FragmentLoginBinding
import com.upn.catatlari.viewmodel.AuthViewModel

class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding.buttonLogin.setOnClickListener {
            val emailUser = loginBinding.etEmail.text.toString().trim()
            val passwordUser = loginBinding.etPassword.text.toString()

            if (emailUser.isEmpty() || passwordUser.isEmpty()) {
                Toast.makeText(requireContext(), "Silahkan masukkan email/password!", Toast.LENGTH_SHORT).show()
            } else {
                authViewModel.login(emailUser, passwordUser)
            }
        }

        loginBinding.txtRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        authViewModel.loginStatus.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Email atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}