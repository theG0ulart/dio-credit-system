package edu.wearedev.liberacao.credito.service

import edu.wearedev.liberacao.credito.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)

}