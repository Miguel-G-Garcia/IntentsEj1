package com.miguel.intentsej1

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import androidx.versionedparcelable.ParcelUtils
import com.miguel.intentsej1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            alarm.setOnClickListener{
                val intent = Intent(this@MainActivity, AlarmActivity::class.java)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }

            }
            Searchweb.setOnClickListener {
                buscaweb("www.google.com")
            }

            Contactos.setOnClickListener {
                abreContactos()
            }

        }
    }

    private fun abreContactos() {

        val webpage: Uri = Uri.parse("content://contacts/people/")
        //("www.google.com")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun buscaweb(texto: String){
            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, texto)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

    }

}