package com.sunnyweather.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author wenji.zhao
 * @time 2023/05/26 10:50 上午
 * @email wj.zhao08@zuche.com
 * @desc
 */
class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    var result: Double = 0.0

    fun setData(result: Double) {
        this.result = result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reslut_layout, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val resultTextView: TextView = itemView.findViewById(R.id.resultTextView)

        fun bind(result: Double) {
            resultTextView.text = "${String.format("%.2f", result)}"
        }

    }

}