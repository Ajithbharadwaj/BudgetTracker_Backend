package com.budgettracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.budgettracker.entity.IncomeEntity;
import com.budgettracker.exception.ResourceNotFoundException;
import com.budgettracker.repository.IncomeRepository;

@Service
public class IncomeService {

	private final IncomeRepository incomeRepo;

	IncomeService(IncomeRepository incomeRepository) {
		this.incomeRepo = incomeRepository;
	}
	
	// Method to create a record
	public IncomeEntity createIncomeRecord(IncomeEntity incomeEntity) {
		return incomeRepo.save(incomeEntity);
	}
	
	// Method to update a record
	public IncomeEntity updateIncomeRecord(IncomeEntity incomeEntity, Long id) {
		IncomeEntity findRecordById = incomeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Unable to find the id: "+id));
		findRecordById.setAmount(incomeEntity.getAmount());
		findRecordById.setDate(incomeEntity.getDate());
		findRecordById.setDescription(incomeEntity.getDescription());
		findRecordById.setSource(incomeEntity.getSource());
		return incomeRepo.save(findRecordById);
	}
	
	// Method to get all the records
	public List<IncomeEntity> getAllIncomeRecords(){
		return incomeRepo.findAll();
	}
	
	// Method to get record by id
	public Optional<IncomeEntity> getIncomeRecordById(Long id) {
		@SuppressWarnings("unused")
		IncomeEntity findRecordById = incomeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No such id found with :" +id));
		return incomeRepo.findById(id);
	}
	
	// Method to delete a record
	public void deleteIncomeRecord(Long id) {
		IncomeEntity findRecordById = incomeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No such id found with :" +id));
		incomeRepo.delete(findRecordById);
	}
}
