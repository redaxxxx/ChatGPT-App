package com.android.developer.prof.reda.chatgptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //here setKeepOnScreenCondition true so, activity redirect another activity & some api call here
        //if setKeepOnScreenCondition false so, activity code not redirect another activity
        splashScreen.setKeepOnScreenCondition{false}
    }
}