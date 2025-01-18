package com.bor96dev.icerockgithubapp.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bor96dev.icerockgithubapp.R
import com.bor96dev.icerockgithubapp.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("GTA5", "onViewCreated auth")

        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        binding.authButton.setOnClickListener {
            Log.d("GTA5", "button is pressed")
            viewModel.onSignButtonPressed()
        }
        binding.textInputEditText.doOnTextChanged { text, _, _, _ ->
            Log.d("GTA5", "text input: $text")
            viewModel.token.value = text.toString()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.actions.collect { action ->
                    Log.d("GTA5", "received action: $action")
                    when (action) {
                        is AuthViewModel.Action.RouteToMain -> {
                            Log.d("GTA5", "navigate")
                            findNavController().navigate(R.id.action_authFragment_to_repositoriesListFragment)

                        }

                        is AuthViewModel.Action.ShowError -> {

                        }
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as? AppCompatActivity)?.supportActionBar?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}