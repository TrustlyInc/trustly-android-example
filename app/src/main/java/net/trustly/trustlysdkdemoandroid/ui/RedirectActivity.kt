package net.trustly.trustlysdkdemoandroid.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class RedirectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO This validation is related with DeepLink strategy and will be included into SDK
        if (intent.data!!.scheme!!.contains("http")) {
            Handler(Looper.getMainLooper()).postDelayed({
                finish()
            }, 700)
        }
    }

}