package org.example.basic;

import java.util.Objects;

public class Patient {

    public Patient(String state, int patientAdmited, int patientRecovered) {
        this.state = state;
        PatientAdmited = patientAdmited;
        PatientRecovered = patientRecovered;
    }

    String state;
    int PatientAdmited;


    int PatientRecovered;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return PatientAdmited == patient.PatientAdmited && PatientRecovered == patient.PatientRecovered && Objects.equals(state, patient.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PatientAdmited, state, PatientRecovered);
    }

    public int getPatientAdmited() {
        return PatientAdmited;
    }

    public void setPatientAdmited(int patientAdmited) {
        PatientAdmited = patientAdmited;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPatientRecovered() {
        return PatientRecovered;
    }

    public void setPatientRecovered(int patientRecovered) {
        PatientRecovered = patientRecovered;
    }


}
