package com.example.submissionakhiraplikasiandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionakhiraplikasiandroid.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding
    private lateinit var list: ArrayList<Art>
    private lateinit var actionBar: ActionBar

    companion object {
        const val EXTRA_ART = "extra_art"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvArt.setHasFixedSize(true)
        list = getListArts()
        showRecyleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
//        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.menu_profile -> {
                Toast.makeText(applicationContext, "Ini adalah notifikasi", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, About::class.java))
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

    private fun getListArts(): ArrayList<Art>{
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataCreated = resources.getStringArray(R.array.data_created)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataLink = resources.getStringArray(R.array.data_link)
        val listArt = ArrayList<Art>()

        for(i in dataTitle.indices){
            val art = Art(dataTitle[i], dataDescription[i], dataPhoto.getResourceId(i, -1),
                dataCreated[i], dataLocation[i], dataLink[i])
            listArt.add(art)
        }
        return listArt
    }

    private fun showRecyleList(){
        binding.rvArt.layoutManager = LinearLayoutManager(this)
        val listArtAdapter = ListArtAdapter(list){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_ART, it)
            startActivity(intent)
        }
        binding.rvArt.adapter = listArtAdapter
    }
}