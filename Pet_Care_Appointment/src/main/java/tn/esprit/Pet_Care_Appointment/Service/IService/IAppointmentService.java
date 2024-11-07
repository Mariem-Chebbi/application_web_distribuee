package tn.esprit.Pet_Care_Appointment.Service.IService;


import tn.esprit.Pet_Care_Appointment.Entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    Appointment saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(Long id, Appointment appointment);
    void deleteAppointment(Long id);
}
