package edu.wearedev.liberacao.credito.service

import edu.wearedev.liberacao.credito.entity.Credit
import edu.wearedev.liberacao.credito.entity.Customer
import org.aspectj.apache.bcel.classfile.Code
import java.util.*

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}