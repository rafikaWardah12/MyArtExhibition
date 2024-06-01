package com.example.submissionakhiraplikasiandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.submissionakhiraplikasiandroid.databinding.ActivityAboutBinding
import com.example.submissionakhiraplikasiandroid.databinding.ItemRowArtBinding

class About : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.menu_profile -> {
                Toast.makeText(applicationContext, "Anda telah berada di Profile", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_logout -> Toast.makeText(applicationContext, "Ini adalah Logout", Toast.LENGTH_SHORT).show()
            R.id.menu_share -> {
                Toast.makeText(applicationContext, "Ini adalah Share Link", Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check Out This Application")
                intent.putExtra(Intent.EXTRA_TEXT, "Your Application Link Here")
                startActivity(Intent.createChooser(intent, "Share Via"))
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}