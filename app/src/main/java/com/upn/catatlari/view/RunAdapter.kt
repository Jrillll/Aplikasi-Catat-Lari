package com.upn.catatlari.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upn.catatlari.databinding.ItemRunBinding
import com.upn.catatlari.model.Run

<<<<<<< HEAD
class RunAdapter(private val onDeleteClick: (Run) -> Unit) : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {
=======
class RunAdapter() : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e

    private var runList = mutableListOf<Run>()

    fun setData(runItems: List<Run>) {
        runList.clear()
        runList.addAll(runItems)
<<<<<<< HEAD
        notifyDataSetChanged()
    }

=======
    }
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder =
        RunViewHolder(ItemRunBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) = holder.bind(runList[position])

    override fun getItemCount(): Int = runList.size

    inner class RunViewHolder(private val binding: ItemRunBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(run: Run) {
            binding.txtRunDate.text = run.runDate
<<<<<<< HEAD
            
            // Format Jarak: 1.12 KM
            val distance = if (run.runDistanceM > 0) {
                "${run.runDistanceKm}.${run.runDistanceM} KM"
            } else {
                "${run.runDistanceKm} KM"
            }
            binding.txtRunDistance.text = distance
            
            // Format Durasi: HH jam MM min atau hanya MM min
            val duration = StringBuilder()
            if (run.runDurationH > 0) {
                duration.append("${run.runDurationH} jam ")
            }
            duration.append("${run.runDurationM} min")
            binding.txtRunDuration.text = duration.toString()
            
            binding.btnDelete.setOnClickListener {
                onDeleteClick(run)
            }
=======
            binding.txtRunDistance.text = "${run.runDuration} M"
            binding.txtRunDuration.text = run.runDuration.toString()
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
        }
    }
}