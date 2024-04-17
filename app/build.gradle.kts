plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.demeter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demeter"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.emoji2:emoji2-views:1.4.0")
    implementation(files("libs\\jtds-1.3.1.jar"))
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.google.firebase:firebase-firestore:24.11.1")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    /*converter-name tends to any one from listed conververts*/
    implementation ("com.squareup.retrofit2:adapter-rxjava:2.7.1")
// HttpRequest and converters
// This is used for logging (Log) the responses of the WebServices
    implementation ("com.squareup.okhttp3:logging-interceptor:4.3.0")
// These are HTTP clients
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:4.3.0")
// This is for receiving plain text from the WebServices
    implementation ("com.squareup.retrofit2:converter-scalars:2.7.1")
// This is for using Observable with Retrofit, so we don't have to worry about threading
    implementation ("com.squareup.retrofit2:adapter-rxjava:2.7.1")
// This is the plain JSON to object Parser
    implementation ("com.google.code.gson:gson:2.10")
// This the RXJava specific for Android
    implementation ("io.reactivex:rxandroid:1.2.1")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //emoji dependecies
    //blurr
    //calendario
    implementation ("com.google.android.material:material:1.11.0")

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-analytics")
}