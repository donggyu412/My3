package com.example.checkid.view.dialogFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.checkid.databinding.DialogFragmentLoginIsSuccessBinding


class LoginIsSuccessDialogFragment : DialogFragment() {
    private var _binding: DialogFragmentLoginIsSuccessBinding? = null
    private val binding get() = _binding!!

    interface OnDialogButtonClickListener {
        fun onDialogButtonClick()
    }

    private var listener: OnDialogButtonClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {
        _binding = DialogFragmentLoginIsSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = parentFragment

        binding.loginIsSuccessButton.setOnClickListener {
            dismiss()

            if (fragment != null) {
                parentFragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}