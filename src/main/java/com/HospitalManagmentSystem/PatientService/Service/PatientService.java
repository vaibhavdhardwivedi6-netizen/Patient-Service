package com.HospitalManagmentSystem.PatientService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalManagmentSystem.PatientService.Entity.Patient;
import com.HospitalManagmentSystem.PatientService.Repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

	private final PatientRepository repo;

	public List<Patient> getAll() {
		return repo.findAll();
	}

	public Patient getOne(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public Patient save(Patient p) {
		return repo.save(p);
	}

	public String delete(Long id) {
		repo.deleteById(id);
		return "delete Successfull";
	}
}
