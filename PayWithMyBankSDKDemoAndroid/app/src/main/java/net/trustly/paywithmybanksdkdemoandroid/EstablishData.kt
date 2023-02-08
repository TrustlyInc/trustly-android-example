package net.trustly.paywithmybanksdkdemoandroid

object EstablishData {

    fun getEstablishDataValues(): Map<String, String> {
        val establishDataValues: MutableMap<String, String> = HashMap()
        establishDataValues["accessId"] = "A48B73F694C4C8EE6306"
        establishDataValues["requestSignature"] = "clYlSWb565B3JGUExdXrK5tyTqM="
        establishDataValues["merchantId"] = "110005514"
        establishDataValues["description"] = "Android SDK Demo"
        establishDataValues["currency"] = "USD"
        establishDataValues["amount"] = "0.00"
        establishDataValues["merchantReference"] = "ABCDREF"
        establishDataValues["paymentType"] = "Retrieval"
        establishDataValues["customer.name"] = "John Smith"
        establishDataValues["customer.address.address1"] = "2000 Broadway Street"
        establishDataValues["customer.address.city"] = "Redwood City"
        establishDataValues["customer.address.state"] = "CA"
        establishDataValues["customer.address.zip"] = "94063"
        establishDataValues["customer.address.country"] = "US"
        establishDataValues["customer.phone"] = "2145553434"
        establishDataValues["customer.email"] = "jsmith@email.com"
        establishDataValues["metadata.urlScheme"] = "sdkdemo://"
        establishDataValues["env"] = "sandbox"
        return establishDataValues
    }

}