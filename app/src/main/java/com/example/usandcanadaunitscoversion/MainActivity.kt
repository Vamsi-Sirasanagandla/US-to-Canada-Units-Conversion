package com.example.usandcanadaunitscoversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.navigation.NavigationBarView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag : String = "Fahrenheit to Celsius"
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("Fahrenheit to Celsius","Celsius to Fahrenheit","Miles to KM","KM to Miles","USD to CAD","CAD to USD")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt();
            if(flag =="Fahrenheit to Celsius")
                resultTV.text = fahrenheitToCelsius(x).toString()+" C";
            else if(flag == "Celsius to Fahrenheit")
                resultTV.text = celsiusToFahrenheit(x).toString()+" F";
            else if(flag == "Miles to KM")
                resultTV.text = milesToKM(x).toString()+" Km";
            else if(flag == "KM to Miles")
                resultTV.text = kmToMiles(x).toString()+" mi";
            else if(flag == "USD to CAD")
                resultTV.text = usdTocad(x).toString()+ " CAD";
            else if(flag == "CAD to USD")
                resultTV.text = cadTousd(x).toString()+ " USD";
            else
                resultTV.text = "Invalid Selection";
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun fahrenheitToCelsius(a: Int): Double {
    val ans= (a-32)/1.8
    return String.format("%.2f", ans).toDouble()
}
public fun celsiusToFahrenheit(a: Int): Double {
    val ans= (a*1.8+32)
    return String.format("%.2f", ans).toDouble()
}
public fun milesToKM(a: Int): Double {
    val ans = a*1.609344
    return String.format("%.2f", ans).toDouble()
}
public fun kmToMiles(a: Int): Double {
    val ans = a*0.621371
    return String.format("%.2f", ans).toDouble()
}
public fun usdTocad(a: Int): Double {
    val ans = a*1.37
    return String.format("%.2f", ans).toDouble()
}
public fun cadTousd(a: Int): Double {
    val ans = a*0.73
    return String.format("%.2f", ans).toDouble()
}