package com.bor96dev.icerockgithubapp.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bor96dev.icerockgithubapp.R
import com.bor96dev.icerockgithubapp.databinding.FragmentRepositoriesListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RepositoriesListFragment : Fragment() {

    private var _binding: FragmentRepositoriesListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RepositoriesListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoriesListBinding.inflate(inflater, container, false)
        val view = binding.root
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("GTA5", "list fragment created")


        (activity as? AppCompatActivity)?.supportActionBar?.title = "Repositories"

        binding.recyclerviewButton.setOnClickListener {
            Log.d("GTA5", "navigate to details")
            findNavController().navigate(R.id.action_repositoriesListFragment_to_detailInfoFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.observe(viewLifecycleOwner) { state ->
                    Log.d("GTA5", "OBSERVING")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}