package net.trustly.trustlysdkdemoandroid

object EstablishData {

    const val DYNAMIC_REQUEST_SIGNATURE = false

    fun getEstablishDataValues(): Map<String, String> {
        val establishDataValues: MutableMap<String, String> = HashMap()
        establishDataValues["accessId"] = "TSwGyK52Mnpt5b8C"
//        establishDataValues["requestSignature"] = "YOUR_REQUEST_SIGNATURE"
        establishDataValues["merchantId"] = "1127"
        establishDataValues["description"] = "Android SDK Demo transaction"
        establishDataValues["currency"] = "USD"
        establishDataValues["merchantReference"] = "g:cac73df7-52b4-47d7-89d3-9628d4cfb65e"
        establishDataValues["paymentType"] = "Retrieval"
        establishDataValues["metadata.urlScheme"] = "sdkdemo://"
        establishDataValues["env"] = "sandbox"
        return establishDataValues
    }

}