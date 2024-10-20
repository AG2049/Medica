package com.example.medica

import androidx.lifecycle.ViewModel

class AppointmentViewModel : ViewModel() {
    var selectedDoctor: Doctor? = null
    var selectedDate: String? = null
    var selectedTime: String? = null
}