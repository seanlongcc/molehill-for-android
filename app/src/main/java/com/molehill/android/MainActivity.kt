package com.molehill.android
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.Writer

class MainActivity : AppCompatActivity() {
    @SuppressLint("HardwareIds")

    override fun onCreate(savedInstanceState: Bundle?) {
        //creates and set the layout to activity_main
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //main function to call other functions
        fun main(){
            gatherData()
        }
        //call main function
        main()
    }
    //function to write data to file
    fun fileWrite(resultsTextView:TextView){
        //name the file after the device model
        val fileName = """${Build.MODEL}.txt"""
        //set content as the output of resultsTextView text box
        val content = resultsTextView.text.toString()

        //create a file to write to and write to the file
        val fileOutputStream: FileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
        fileOutputStream.write(content.toByteArray())

        //notification that it has been saved to file
        showToast("Saved to file")
    }

    //gathers data of device
    fun gatherData(){
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        resultsTextView.text = ("BOARD: " + Build.BOARD + "\n"
                + "BOOTLOADER: " + Build.BOOTLOADER + "\n"
                + "BRAND: " + Build.BRAND + "\n"
                + "DEVICE: " + Build.DEVICE + "\n"
                + "DISPLAY: " + Build.DISPLAY + "\n"
                + "FINGERPRINT: " + Build.FINGERPRINT + "\n"
                + "HARDWARE: " + Build.HARDWARE + "\n"
                + "HOST: " + Build.HOST + "\n"
                + "ID: " + Build.ID + "\n"
                + "MANUFACTURER: " + Build.MANUFACTURER + "\n"
                + "MODEL: " + Build.MODEL + "\n"
                + "PRODUCT: " + Build.PRODUCT + "\n"
                + "SERIAL: " + Build.SERIAL + "\n"
                + "TAGS: " + Build.TAGS + "\n"
                + "USER: " + Build.TIME + "\n"
                + "USER: " + Build.USER + "\n")
        //call fileWrite() to write to a file
        fileWrite(resultsTextView)
    }

    //notification pop up, extension function for Context
    fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, text, duration).show()
    }
}