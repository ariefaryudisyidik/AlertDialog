package com.binar.ariefaryudisyidik.dialogsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.binar.ariefaryudisyidik.dialogsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionButton()
    }

    private fun actionButton() {
        binding.btnDialogCancelable.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Cancelable")
            dialog.setMessage("Dialog Cancelable bisa ditutup dengan klik bagian luar dialog")
            dialog.setCancelable(true)
            dialog.show()
        }

        binding.btnDialogNonCancelable.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Non Cancelable")
            dialog.setMessage("Dialog Non Cancelable harus ditutup dari tombol Action")
            dialog.setCancelable(false)

            dialog.setPositiveButton("Close") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            dialog.show()
        }

        binding.btnDialogPositiveNegative.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog with Button")
            dialog.setMessage("Dialog with Button untuk berbagaii aksi")
            dialog.setIcon(R.mipmap.ic_launcher)

            dialog.setCancelable(false)
            dialog.setPositiveButton("Positive Button") { _, _ ->
                Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("Negative Button") { _, _ ->
                Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.setNeutralButton("Neutral Button") { _, _ ->
                Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
        }

        binding.btnCustomDialog.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)

            val dialog = dialogBuilder.create()
            dialog.setCancelable(false)

            val btnClose = view.findViewById<Button>(R.id.btn_close)
            btnClose.setOnClickListener {
                Toast.makeText(this, "Custom Dialog Closed", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialog.show()
        }

        binding.btnFragmentDialog.setOnClickListener {
            val dialogFragment = AlertDialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(supportFragmentManager, null)
        }
    }
}