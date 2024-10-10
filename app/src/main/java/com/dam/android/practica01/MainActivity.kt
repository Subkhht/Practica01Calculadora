package com.dam.android.practica01

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.controls.actions.ModeAction
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var botonSUM: Button
    private lateinit var botonRES: Button
    private lateinit var botonMUL: Button
    private lateinit var botonDIV: Button
    private lateinit var resultado: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.editTextNumber)
        editText2 = findViewById(R.id.editTextNumber2)
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                Log.i("edittext", "after "+s)
            }


            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
                Log.i("edittext", String.format("before %s", s))
            }


            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.i("edittext", String.format("ontext %s", s))
            }
        })

        editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                Log.i("edittext2", "after "+s)
            }


            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
                Log.i("edittext2", String.format("before %s", s))
            }


            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.i("edittext2", String.format("ontext %s", s))
            }
        })

        botonSUM = findViewById(R.id.buttonSUM)
        botonRES = findViewById(R.id.buttonRES)
        botonMUL = findViewById(R.id.buttonMUL)
        botonDIV = findViewById(R.id.buttonDIV)
        resultado = findViewById(R.id.resultado)

        botonSUM.setOnClickListener {
            resultado.text = (editText.text.toString().toLong() + editText2.text.toString().toLong()).toString()
            Log.i("boton", "botonSUM")
        }

        botonRES.setOnClickListener {
            resultado.text = (editText.text.toString().toLong() - editText2.text.toString().toLong()).toString()
            Log.i("boton", "botonRES")
        }

        botonMUL.setOnClickListener {
            resultado.text = (editText.text.toString().toLong() * editText2.text.toString().toLong()).toString()
            Log.i("boton", "botonMUL")
        }

        botonDIV.setOnClickListener {
            resultado.text = (editText.text.toString().toLong() / editText2.text.toString().toLong()).toString()
            Log.i("boton", "botonDIV")
        }
    }
}

