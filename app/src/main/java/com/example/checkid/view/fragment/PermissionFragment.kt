package com.example.checkid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.checkid.R
import com.example.checkid.databinding.FragmentPermissionBinding
import com.example.checkid.view.dialogFragment.PermissionIsFailDialogFragment
import com.example.checkid.view.dialogFragment.PermissionIsSuccessDialogFragment
import com.example.checkid.viewmodel.PermissionViewModel

class PermissionFragment: Fragment(R.layout.fragment_permission) {
    private var _binding : FragmentPermissionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PermissionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPermissionBinding.inflate(inflater, container, false)

        val permissions = viewModel.getAllPermissions()

        binding.permissionsTextView.text = permissions.joinToString("\n") { permission ->
            "- $permission"
        }

        binding.checkPermissionButton.setOnClickListener {
            if (viewModel.checkAllPermissions(requireContext())) {
                PermissionIsSuccessDialogFragment().show(childFragmentManager, "")
            }

            else {
                PermissionIsFailDialogFragment().show(childFragmentManager, "")
            }
        }

        binding.openSettingsButton.setOnClickListener {
            viewModel.openAppSettings(requireContext())
        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}