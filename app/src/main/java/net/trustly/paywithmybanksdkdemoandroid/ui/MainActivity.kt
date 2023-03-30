package net.trustly.paywithmybanksdkdemoandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.paywithmybank.android.sdk.views.PayWithMyBankView
import net.trustly.paywithmybanksdkdemoandroid.EstablishData
import net.trustly.paywithmybanksdkdemoandroid.R
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val establishDataValues = EstablishData.getEstablishDataValues().toMutableMap()
        val payWithMyBankWidget = findViewById<PayWithMyBankView>(R.id.payWithMyBankWidget)
        payWithMyBankWidget.selectBankWidget(establishDataValues).onBankSelected { _, data ->
            establishDataValues[PAYMENT_PROVIDER_ID] = data[PAYMENT_PROVIDER_ID].toString()
        }

        val connectWithMyBankButton = findViewById<AppCompatButton>(R.id.btnConnectMyBank)
        connectWithMyBankButton.setOnClickListener {
            val intent = Intent(this@MainActivity, LightBoxActivity::class.java)
            intent.putExtra(LightBoxActivity.ESTABLISH_DATA, establishDataValues as Serializable)
            startActivity(intent)
        }
    }

    companion object {
        private const val PAYMENT_PROVIDER_ID = "paymentProviderId"
    }

}