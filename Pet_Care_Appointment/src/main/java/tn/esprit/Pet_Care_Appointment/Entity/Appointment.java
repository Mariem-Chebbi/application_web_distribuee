package tn.esprit.Pet_Care_Appointment.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_and_pet_id")
    private OwnerAndPet ownerAndPet;

    private String veterinarianName;
    private String appointmentDate; // on peut utiliser LocalDate ou LocalDateTime
    
 // Getters et Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OwnerAndPet getOwnerAndPet() {
		return ownerAndPet;
	}
	public void setOwnerAndPet(OwnerAndPet ownerAndPet) {
		this.ownerAndPet = ownerAndPet;
	}
	public String getVeterinarianName() {
		return veterinarianName;
	}
	public void setVeterinarianName(String veterinarianName) {
		this.veterinarianName = veterinarianName;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

    
}