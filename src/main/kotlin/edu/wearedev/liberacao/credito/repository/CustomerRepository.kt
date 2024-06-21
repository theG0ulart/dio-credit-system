package edu.wearedev.liberacao.credito.repository

import edu.wearedev.liberacao.credito.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}