package com.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgettracker.entity.IncomeEntity;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {

}
