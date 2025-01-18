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
    private lateinit var adapter: RecyclerViewAdapter


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

        adapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = adapter

        binding.errorButton.setOnClickListener {
            Log.d("GTA5", "navigate to details")
            findNavController().navigate(R.id.action_repositoriesListFragment_to_detailInfoFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.observe(viewLifecycleOwner) { state ->
                    when (state) {
                        is RepositoriesListViewModel.State.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.recyclerView.visibility = View.GONE
                        }

                        is RepositoriesListViewModel.State.Loaded -> {
                            adapter.setItems(state.repos)
                        }

                        is RepositoriesListViewModel.State.Error -> {
                            binding.imageError.setImageResource(R.drawable.internet_error)
                            binding.recyclerView.visibility = View.GONE
                            binding.titleError.text = "Connection error"
                            binding.descriptionError.text = "Check your internet connection"
                            binding.errorButton.visibility = View.VISIBLE
                            binding.errorButton.text = "RETRY"
                        }

                        is RepositoriesListViewModel.State.Empty -> {
                            binding.imageError.setImageResource(R.drawable.empty_error)
                            binding.recyclerView.visibility = View.GONE
                            binding.titleError.text = "Empty"
                            binding.descriptionError.text = "No repositories at the moment"
                            binding.errorButton.visibility = View.VISIBLE
                            binding.errorButton.text = "REFRESH"

                        }

                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}