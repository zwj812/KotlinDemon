package com.sunnyweather.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MianViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MianViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnSubmit.setOnClickListener {
            // 点击 submit 按钮时，获取文本框 1 和文本框 2 中的值，计算结果
            val amount = viewModel.amount.value ?: 0.0
            val seconds = viewModel.seconds.value ?: 0.0
            val result = amount * seconds
            // 跳转到下一个页面，并把结果传递过去
            startActivity(ResultActivity.newIntent(this, result))
        }
    }



    private fun formatSeconds(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }
}