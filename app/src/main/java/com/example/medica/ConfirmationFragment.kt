package com.example.medica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ConfirmationFragment : Fragment() {

    private lateinit var viewModel: AppointmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)

        // Obtener el ViewModel compartido
        viewModel = ViewModelProvider(requireActivity()).get(AppointmentViewModel::class.java)

        // Mostrar el resumen de la cita
        val doctorNameTextView: TextView = view.findViewById(R.id.doctor_name)
        val doctorSpecialtyTextView: TextView = view.findViewById(R.id.doctor_specialty)
        val appointmentDateTextView: TextView = view.findViewById(R.id.appointment_date)
        val appointmentTimeTextView: TextView = view.findViewById(R.id.appointment_time)

        doctorNameTextView.text = viewModel.selectedDoctor?.name
        doctorSpecialtyTextView.text = viewModel.selectedDoctor?.specialty
        appointmentDateTextView.text = viewModel.selectedDate
        appointmentTimeTextView.text = viewModel.selectedTime

        // Confirmar la cita
        val confirmButton: Button = view.findViewById(R.id.confirm_button)
        confirmButton.setOnClickListener {
            Toast.makeText(requireContext(), "Cita confirmada", Toast.LENGTH_SHORT).show()

        }

        return view
    }
}
