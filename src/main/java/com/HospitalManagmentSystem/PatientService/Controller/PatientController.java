package com.HospitalManagmentSystem.PatientService.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagmentSystem.PatientService.Entity.Patient;
import com.HospitalManagmentSystem.PatientService.Service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {

	private final PatientService service;

	@GetMapping
	public ResponseEntity<List<Patient>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@PostMapping
	public ResponseEntity<Patient> save(@RequestBody Patient p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(p));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getOne(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		return ResponseEntity.ok(service.delete(id));
	}
}
