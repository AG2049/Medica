package com.example.medica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(
    private val doctorList: List<Doctor>,
    private val onDoctorSelected: (Doctor) -> Unit
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctorList[position]
        holder.bind(doctor)
    }

    override fun getItemCount(): Int = doctorList.size

    // Definir la clase DoctorViewHolder
    inner class DoctorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.doctor_name)
        private val specialtyTextView: TextView = view.findViewById(R.id.doctor_specialty)

        fun bind(doctor: Doctor) {
            nameTextView.text = doctor.name
            specialtyTextView.text = doctor.specialty
            itemView.setOnClickListener {
                onDoctorSelected(doctor)
            }
        }
    }
}