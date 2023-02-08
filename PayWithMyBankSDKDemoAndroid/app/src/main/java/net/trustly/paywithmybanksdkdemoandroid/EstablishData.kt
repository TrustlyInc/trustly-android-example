package net.trustly.paywithmybanksdkdemoandroid

object EstablishData {

    fun getEstablishDataValues(): Map<String, String> {
        val establishDataValues: MutableMap<String, String> = HashMap()
        establishDataValues["accessId"] = "A48B73F694C4C8EE6307"
        establishDataValues["requestSignature"] = "clYlSWb565B3JGUExdXrK5tyTqM="
        establishDataValues["merchantId"] = "1009542823"
        establishDataValues["description"] = "Android SDK Demo"
        establishDataValues["currency"] = "USD"
        establishDataValues["amount"] = "0.00"
        establishDataValues["merchantReference"] = "3D51F3A42EFE499A"
        establishDataValues["paymentType"] = "Retrieval"
        establishDataValues["customer.name"] = "Freddie Mercury"
        establishDataValues["customer.address.address1"] = "96725 Champlin Shoal"
        establishDataValues["customer.address.city"] = "London"
        establishDataValues["customer.address.state"] = "London"
        establishDataValues["customer.address.zip"] = "DZ03 1WN"
        establishDataValues["customer.address.country"] = "US"
        establishDataValues["customer.phone"] = "+44 123456789"
        establishDataValues["customer.email"] = "freddie.mercury@email.com"
        establishDataValues["metadata.urlScheme"] = "sdkdemo://"
        establishDataValues["env"] = "sandbox"
        return establishDataValues
    }

}