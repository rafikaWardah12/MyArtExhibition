package com.example.submissionakhiraplikasiandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.submissionakhiraplikasiandroid.MainActivity.Companion.EXTRA_ART
import com.example.submissionakhiraplikasiandroid.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var art: Art

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val receivedArt = intent.getParcelableExtra<Art>("DETAIL". Art::clas.java)
//        if(receivedArt != null){
//            binding.detailItemTitle.text = receivedArt.title
//            binding.detailItemPhoto.setImageResource(receivedArt.photo)
//            binding.detailItemDescription.text = receivedArt.description

        val receivedArt = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Art>(EXTRA_ART, Art::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Art>(EXTRA_ART)
        }
        if(receivedArt != null) {
            art = receivedArt
            binding.apply {
                detailItemTitle.text = receivedArt.title
                detailItemPhoto.setImageResource(receivedArt.photo)
                detailItemDescription.text = receivedArt.description
                detailItemCreated.text = receivedArt.created
               detailItemLocation.text = receivedArt.location
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_share, menu)
        return true
//        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.menu_share -> {
                Toast.makeText(applicationContext, "Ini adalah Share Link", Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check Out This Application")
                intent.putExtra(Intent.EXTRA_TEXT, art.link)
                startActivity(Intent.createChooser(intent, "Share Via"))
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
