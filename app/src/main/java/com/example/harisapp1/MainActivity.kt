package com.example.harisapp1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private val TAG = "cekString" // Tag untuk logging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Kode lainnya seperti sebelumnya...
        val websiteEditText: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.open_website_button)
        openWebsiteButton.setOnClickListener {
            val websiteUrl = websiteEditText.text.toString()
            openWebsite(websiteUrl)
        }

        val locationEditText: EditText = findViewById(R.id.location_edit_text)
        val locationButton: Button = findViewById(R.id.location_button)
        locationButton.setOnClickListener {
            val locationName = locationEditText.text.toString()
            openLocation(locationName)
        }

        val shareEditText: EditText = findViewById(R.id.share_edit_text)
        val shareTextButton: Button = findViewById(R.id.share_text_button)
        shareTextButton.setOnClickListener {
            val shareText = shareEditText.text.toString()
            shareText(shareText)
        }

        val editSend: EditText = findViewById(R.id.edit_send)
        val btnPindah: Button = findViewById(R.id.btn_pindah)

        btnPindah.setOnClickListener {
            val dikirim = editSend.text.toString()

            // Menambahkan log
            Log.v("checkApp", dikirim)

            // Menambahkan toast
            Toast.makeText(applicationContext, dikirim, Toast.LENGTH_LONG).show()

            // Membuat intent untuk berpindah ke SecondActivity
            val pindah = Intent(this@MainActivity, SecondActivity::class.java)

            // Menambahkan data ke intent
            pindah.putExtra("varFromMain", dikirim)

            // Memulai activity baru
            startActivity(pindah)
        }
    }

    // Metode lainnya tetap sama...
    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun openLocation(location: String) {
        val uri = Uri.parse("geo: 0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    private fun shareText(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, "Share Text"))
    }
}