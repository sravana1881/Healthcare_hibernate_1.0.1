package healthcare.model;

import jakarta.persistence.*;
import lombok.ToString;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Doctors")
@ToString(exclude = { "patients", "appointments"})
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="DoctorID")
    int doctorId;
    @Column(name="FirstName")
    String firstName;
    @Column(name="LastName")
    String lastName;
    @Column(name="Specialty")
    String specialty;
    @Column(name="Email")
    String email;

    @OneToMany(mappedBy = "doctor" , cascade= CascadeType.ALL)
    Set<Appointment> appointments= new HashSet<Appointment>();


    @ManyToMany
    @JoinTable(
           name ="doctor_patient",
            joinColumns = @JoinColumn(name="DoctorID"),
            inverseJoinColumns = @JoinColumn(name ="PatientID")
    )
    Set<Patient> patients=new HashSet<>();



    public Doctor() {
    }

    public Doctor(int doctorId, String firstName, String lastName, String specialty, String email) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.email = email;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId;
    }



    @Override
    public int hashCode() {
        return Objects.hash(doctorId);

    }
}
