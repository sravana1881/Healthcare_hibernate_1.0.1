package healthcare.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Objects;

@Entity
@Table(name="Appointments")
@Getter
@Setter
@ToString(exclude = {"patient", "doctor"})
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="AppointmentID")
    int appointmentId;
//    @Column(name="PatientID")
//    int patientId;
//    @Column(name="DoctorID")
//    int doctorId;
    @Column(name="AppointmentDate")
    String appointmentDate;
    @Column(name="Notes")
    String notes;

    @ManyToOne
    @JoinColumn(name="PatientID")
    Patient patient;

    @ManyToOne
    @JoinColumn(name="DoctorID")
    Doctor doctor;

    public Appointment() {
    }



    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentId == that.appointmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);

    }
}
