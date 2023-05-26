package com.sunnyweather.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sunnyweather.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var reslutAdapter: ResultAdapter
    private var result: Double = 0.0

    companion object {
        private const val EXTRA_RESULT = "result"
        fun newIntent(context: Context, result: Double): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(EXTRA_RESULT, result)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        reslutAdapter = ResultAdapter()

        binding.recyclerView.adapter = reslutAdapter

        result = intent.getDoubleExtra(EXTRA_RESULT, 0.0)
        reslutAdapter.setData(result)

    }
}