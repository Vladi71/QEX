package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun enteringText(s: String) {
            binding.matOperationTv.append(s)
        }

        with(binding) {
            Tv0.setOnClickListener { enteringText("0") }
            Tv1.setOnClickListener { enteringText("1") }
            Tv2.setOnClickListener { enteringText("2") }
            Tv3.setOnClickListener { enteringText("3") }
            Tv4.setOnClickListener { enteringText("4") }
            Tv5.setOnClickListener { enteringText("5") }
            Tv6.setOnClickListener { enteringText("6") }
            Tv7.setOnClickListener { enteringText("7") }
            Tv8.setOnClickListener { enteringText("8") }
            Tv9.setOnClickListener { enteringText("9") }
            subtractTv.setOnClickListener { enteringText("-") }
            divisionTv.setOnClickListener { enteringText("/") }
            parenthesisTv1.setOnClickListener { enteringText("(") }
            parenthesisTv2.setOnClickListener { enteringText(")") }
            multiplicationTv.setOnClickListener { enteringText("*") }
            addTv.setOnClickListener { enteringText("+") }
            pointTv.setOnClickListener { enteringText(".") }
            clearTv.setOnClickListener {
                matOperationTv.text = ""
                resultTv.text = ""
            }
            backIv.setOnClickListener {
                val str = binding.matOperationTv.text.toString()
                if (str.isNotEmpty()) {
                    matOperationTv.text = str.substring(0, str.length - 1)
                }
            }
            equallyTv.setOnClickListener {
                try {
                    val exBuild = ExpressionBuilder(matOperationTv.text.toString()).build()
                    val result = exBuild.evaluate()
                    val longRes = result.toLong()
                    if (result == longRes.toDouble()) {
                        resultTv.text = longRes.toString()
                    } else {
                        resultTv.text = result.toString()
                    }
                } catch (e: Exception) {
                    Log.d("Error", "${e.message}")
                }
            }
        }
    }
}