package com.ksusha.vel.marvelfank.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ksusha.vel.marvelfank.data.remotedata.model.Item
import com.ksusha.vel.marvelfank.data.remotedata.model.Result
import com.ksusha.vel.marvelfank.databinding.ResultListItemBinding
import com.ksusha.vel.marvelfank.presentation.view.HeroActivity


class ResultAdapter(private val context: Context, private val results: MutableList<Result>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = ResultListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = results[position]
        val path: String = getPath(position)
        holder.bind(result, path)

    }

    override fun getItemCount(): Int {
        return results.size
    }

    private fun getPath(position: Int): String {
        return (results[position].thumbnail.path
                + "/portrait_medium."
                + results[position].thumbnail.extension)
    }


    class ResultViewHolder(resultListItemBinding: ResultListItemBinding) :
        RecyclerView.ViewHolder(resultListItemBinding.root) {

        private val binding = resultListItemBinding

        fun bind(result: Result, path: String) {
            binding.titleTextView.text = result.name
            Glide.with(binding.marvelImageView.context)
                .load(path)
                .into(binding.marvelImageView)

            binding.root.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent: Intent = setIntentComics(result, path)
                    binding.root.context.startActivity(intent)
                }
            })

        }

        private fun getListComics(result: Result): String {
            val comics: List<Item> = result.comics.items
            var comicsData = "Comics:" + "\n"
            for (i in comics) {
                comicsData = comicsData + i.name + "\n"
            }

            return comicsData
        }

        private fun setIntentComics(result: Result, path: String): Intent {
            val intent = Intent(binding.root.context, HeroActivity::class.java)
            intent.putExtra("dataId", result.id)
            intent.putExtra("dataName", result.name)
            intent.putExtra("dataDescription", result.description)
            intent.putExtra("dataImagePath", path)
            intent.putExtra("dataComics", getListComics(result))
            return intent
        }

    }
}





