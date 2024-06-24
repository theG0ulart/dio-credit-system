package edu.wearedev.liberacao.credito.service.impl

import edu.wearedev.liberacao.credito.entity.Customer
import edu.wearedev.liberacao.credito.exception.BusinessException
import edu.wearedev.liberacao.credito.repository.CustomerRepository
import edu.wearedev.liberacao.credito.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
    ): ICustomerService {


    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)



    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow { throw BusinessException("Id $id not found") }


    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}