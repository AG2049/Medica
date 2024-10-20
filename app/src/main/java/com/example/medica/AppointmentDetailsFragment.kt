package com.example.medica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AppointmentDetailsFragment : Fragment() {

    private lateinit var viewModel: AppointmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_appointment_details, container, false)

        // Obtener el ViewModel compartido
        viewModel = ViewModelProvider(requireActivity()).get(AppointmentViewModel::class.java)

        // Mostrar la información del médico seleccionado
        val doctorNameTextView: TextView = view.findViewById(R.id.doctor_name)
        val doctorSpecialtyTextView: TextView = view.findViewById(R.id.doctor_specialty)
        doctorNameTextView.text = viewModel.selectedDoctor?.name
        doctorSpecialtyTextView.text = viewModel.selectedDoctor?.specialty

        // Configurar DatePicker y TimePicker
        val datePicker: DatePicker = view.findViewById(R.id.date_picker)
        val timePicker: TimePicker = view.findViewById(R.id.time_picker)
        timePicker.setIs24HourView(true)

        // Validar y pasar al siguiente fragment cuando se seleccionen fecha y hora válidas
        val nextButton: Button = view.findViewById(R.id.next_button)
        nextButton.setOnClickListener {

            // Validación de fecha y hora
            val selectedDate = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year}"
            val selectedTime = "${timePicker.hour}:${timePicker.minute}"

            viewModel.selectedDate = selectedDate
            viewModel.selectedTime = selectedTime

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, ConfirmationFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}


