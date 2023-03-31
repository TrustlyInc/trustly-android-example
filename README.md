# Trustly Android Example App

The purpose of this example app is to demonstrate how to implement and use the [Trustly Android SDK](https://amer.developers.trustly.com/payments/docs/android-quickstart).


## Getting Started

Follow the steps below to run this example app with your own Trustly API credentials.

### Prerequisites

- [Android Studio Electric Eel (2022.1.1)](https://developer.android.com/studio/releases) or higher
- Trustly API credentials and Merchant ID (provided by Trustly)

### Setup

1. Open Android Studio
2. File -> Open -> "trustly-android-example"
3. Wait for project to finish building
4. Open the [Establish Data](./app/src/main/java/net/trustly/paywithmybanksdkdemoandroid/EstablishData.kt) file and insert your credentials into the placeholders:

```
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
```
5. Setup a target device or emulator and "Run" the application

## License

[MIT License](https://github.com/TrustlyInc/trustly-android-example/blob/DEV/LICENSE)