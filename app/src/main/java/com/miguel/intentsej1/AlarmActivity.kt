package com.miguel.intentsej1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import com.miguel.intentsej1.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAlarmBinding.inflate(layoutInflater).apply {
            setContentView(root)

            btnAlarm.setOnClickListener {
                val hora =
                    createAlarm(
                        nombre.text.toString(),
                        horas.hour,
                        horas.minute
                    )
                }
            }
        }

    private fun createAlarm(nombre: String, hour: Int, minute: Int){
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, nombre)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minute)
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}
