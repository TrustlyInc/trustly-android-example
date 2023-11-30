package net.trustly.paywithmybanksdkdemoandroid.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.paywithmybank.android.sdk.views.PayWithMyBankView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.trustly.paywithmybanksdkdemoandroid.EstablishData
import net.trustly.paywithmybanksdkdemoandroid.R
import net.trustly.paywithmybanksdkdemoandroid.data.RetrofitClient
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val mCompositeDisposable: CompositeDisposable
        get() = CompositeDisposable()

    private fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.addAll(disposable)
    }

    private fun unsubscribe() {
        mCompositeDisposable.clear()
    }

    private val establishDataValues = EstablishData.getEstablishDataValues().toMutableMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postSignature(establishDataValues)

        val connectWithMyBankButton = findViewById<AppCompatButton>(R.id.btnConnectMyBank)
        connectWithMyBankButton.setOnClickListener {
            val intent = Intent(this@MainActivity, LightBoxActivity::class.java)
            intent.putExtra(LightBoxActivity.ESTABLISH_DATA, establishDataValues as Serializable)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        unsubscribe()
        super.onDestroy()
    }

    private fun postSignature(establishDataValues: MutableMap<String, String>) {
        val retrofitClient = RetrofitClient.getClient()
        addDisposable(retrofitClient.postSignature(establishDataValues)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate {
                initWidget()
            }
            .subscribe({
                Toast.makeText(this, it.string(), Toast.LENGTH_SHORT).show()
                establishDataValues["requestSignature"] = it.string()
            }, {
                Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
            })
        )
    }

    private fun initWidget() {
        val payWithMyBankWidget = findViewById<PayWithMyBankView>(R.id.payWithMyBankWidget)
        payWithMyBankWidget.selectBankWidget(establishDataValues).onBankSelected { _, data ->
            establishDataValues[PAYMENT_PROVIDER_ID] = data[PAYMENT_PROVIDER_ID].toString()
        }
    }

    companion object {
        private const val PAYMENT_PROVIDER_ID = "paymentProviderId"
    }

}