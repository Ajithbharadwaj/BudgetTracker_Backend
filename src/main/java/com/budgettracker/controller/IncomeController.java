package com.budgettracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgettracker.entity.IncomeEntity;
import com.budgettracker.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {

	private final IncomeService incomeService;
	
	public IncomeController(IncomeService incomeService) {
		this.incomeService = incomeService;
	}
	
	// Create Record
	@PostMapping("/add")
	public IncomeEntity createRecord(@RequestBody IncomeEntity incomeEntity) {
		return incomeService.createIncomeRecord(incomeEntity);
	}
	
	// Get all records
	@GetMapping("/getallrecords")
	public List<IncomeEntity> getAllRecords(){
		return incomeService.getAllIncomeRecords();
	}
	
	// Get records by id
	@GetMapping("/{id}")
	public Optional<IncomeEntity> getRecordById(@PathVariable Long id) {
		return incomeService.getIncomeRecordById(id);
	}
	
	// Update a record
	@PutMapping("/{id}")
	public IncomeEntity updateRecord(@RequestBody IncomeEntity incomeEntity, @PathVariable Long id) {
		return incomeService.updateIncomeRecord(incomeEntity, id);
	}
	
	// Delete a record
	@DeleteMapping("/{id}")
	public void deleteRecord(@PathVariable Long id) {
		incomeService.deleteIncomeRecord(id);
	}
}
