package net.trustly.trustlysdkdemoandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.trustly.android.sdk.interfaces.Trustly
import net.trustly.android.sdk.interfaces.TrustlyCallback
import net.trustly.android.sdk.views.TrustlyView
import net.trustly.trustlysdkdemoandroid.R

class LightBoxActivity : AppCompatActivity() {

    private lateinit var lightBoxWidget: TrustlyView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_box)

        val establishDataValues = intent.getSerializableExtra(ESTABLISH_DATA) as Map<String, String>

        lightBoxWidget = findViewById(R.id.lightBoxWidget)
        lightBoxWidget.establish(establishDataValues)
            .onReturn(
                (TrustlyCallback { _: Trustly, _: Map<String, String> ->
                    redirectToScreen(Callback.RETURN)
                })
            ).onCancel(
                (TrustlyCallback { _: Trustly, _: Map<String, String> ->
                    redirectToScreen(Callback.CANCEL)
                })
            )
    }

    override fun onRestart() {
        super.onRestart()

        lightBoxWidget.proceedToChooseAccount()
    }

    private fun redirectToScreen(callback: Callback) {
        val intent = Intent(this, ResultActivity::class.java)
        val result = when (callback) {
            Callback.RETURN -> { ResultActivity.Result.RETURN }
            Callback.CANCEL -> { ResultActivity.Result.CANCEL }
        }
        intent.putExtra(ResultActivity.RESULT, result)
        startActivity(intent)
        finish()
    }

    private enum class Callback {
        RETURN, CANCEL
    }

    companion object {
        const val ESTABLISH_DATA = "establishData"
    }
}
