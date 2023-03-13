package net.trustly.paywithmybanksdkdemoandroid

object EstablishData {

    fun getEstablishDataValues(): Map<String, String> {
        val establishDataValues: MutableMap<String, String> = HashMap()
        establishDataValues["accessId"] = "YOUR_ACCESS_ID"
        establishDataValues["requestSignature"] = "YOUR_REQUEST_SIGNATURE"
        establishDataValues["merchantId"] = "YOUR_MERCHANT_ID"
        establishDataValues["description"] = "Android SDK Demo"
        establishDataValues["currency"] = "USD"
        establishDataValues["merchantReference"] = "MERCHANT_REFERENCE"
        establishDataValues["paymentType"] = "Retrieval"
        establishDataValues["metadata.urlScheme"] = "sdkdemo://"
        establishDataValues["env"] = "sandbox"
        return establishDataValues
    }

}