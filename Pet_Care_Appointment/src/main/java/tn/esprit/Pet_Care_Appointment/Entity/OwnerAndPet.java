package tn.esprit.Pet_Care_Appointment.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "owner_and_pet")
public class OwnerAndPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private String petName;
    private String petType; //"Chien", "Chat", etc.
    
    
  //Getters et Setters
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}

    
    
}