package com.binar.ariefaryudisyidik.dialogsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.binar.ariefaryudisyidik.dialogsample.databinding.FragmentAlertDialogBinding

class AlertDialogFragment : DialogFragment() {

    private var _binding: FragmentAlertDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlertDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            Toast.makeText(
                activity,
                "DialogFragment ditutup dari dalam fragment",
                Toast.LENGTH_SHORT
            ).show()
            dismiss()
        }
    }


}