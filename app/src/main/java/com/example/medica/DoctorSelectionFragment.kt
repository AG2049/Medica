package com.example.medica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DoctorSelectionFragment : Fragment() {

    // Definir el ViewModel que se compartirá entre los fragments
    private lateinit var viewModel: AppointmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el ViewModel compartido
        viewModel = ViewModelProvider(requireActivity())[AppointmentViewModel::class.java]

        // Inicializar el RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.doctor_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //  Lista de médicos
        val doctors = listOf(
            Doctor("Dr. Kevin P.", "Ortopedia", "Disponible"),
            Doctor("Dra. María F.", "Dermatología", "No disponible"),
            Doctor("Dr. Pablo P.", "Pediatría", "Disponible"),
            Doctor(name = "Dr. simi", specialty = "Médico general", availability = "No disponible"),
            Doctor(name = "Dra. Juguetes", specialty = "Oncología", availability = "Disponible")
        )

        // Configuracion del adaptador
        val adapter = DoctorAdapter(doctors) { selectedDoctor ->
            // Asignacion del doctor seleccionado al ViewModel
            viewModel.selectedDoctor = selectedDoctor

            // Cambiar al siguiente fragment (AppointmentDetailsFragment)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, AppointmentDetailsFragment())
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        return inflater.inflate(R.layout.fragment_doctor_selection, container, false)
    }
}
