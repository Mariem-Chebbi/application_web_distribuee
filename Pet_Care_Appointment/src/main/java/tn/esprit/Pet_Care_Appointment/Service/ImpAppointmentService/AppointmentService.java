package tn.esprit.Pet_Care_Appointment.Service.ImpAppointmentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Pet_Care_Appointment.Entity.Appointment;
import tn.esprit.Pet_Care_Appointment.Repository.AppointmentRepository;
import tn.esprit.Pet_Care_Appointment.Service.IService.IAppointmentService ;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment updatedAppointment = existingAppointment.get();
            updatedAppointment.setVeterinarianName(appointment.getVeterinarianName());
            updatedAppointment.setAppointmentDate(appointment.getAppointmentDate());
            updatedAppointment.setOwnerAndPet(appointment.getOwnerAndPet());
            return appointmentRepository.save(updatedAppointment);
        }
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
