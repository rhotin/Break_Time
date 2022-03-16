package com.rhappdeveloper.breaktime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import com.rhappdeveloper.breaktime.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.breakAmountET.transformationMethod = HideReturnsTransformationMethod.getInstance()

        binding.calculateBtn.setOnClickListener {

            var resultMinutesUnder10 = "0"
            var resultHour: Int = binding.datePicker1.hour
            var resultMinutes: Int = binding.datePicker1.minute
            var resultBreakTime: Int = if (binding.breakAmountET.text.toString().trim().isEmpty())
                0
            else
                binding.breakAmountET.text.toString().toInt()

            if (resultBreakTime > 59) {
                resultHour += resultBreakTime.floorDiv(60)
                resultBreakTime %= 60
            }

            resultMinutes += resultBreakTime

            if (resultMinutes > 59) {
                resultHour += 1
                resultMinutes -= 60
            }
            if (resultHour > 12)
                resultHour %= 12

//            if (resultMinutes < 10) {
//                binding.resultTV.text = "$resultHour:$resultMinutesUnder10$resultMinutes"
//            } else {
//                binding.resultTV.text = "$resultHour:$resultMinutes"
//            }
            binding.resultTV.text = String.format("%2d:%02d", resultHour, resultMinutes)
        }
    }
}