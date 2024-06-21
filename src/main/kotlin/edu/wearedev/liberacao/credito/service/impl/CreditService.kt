package edu.wearedev.liberacao.credito.service.impl

import edu.wearedev.liberacao.credito.entity.Credit
import edu.wearedev.liberacao.credito.repository.CreditRepository
import edu.wearedev.liberacao.credito.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomer(customerId)

    override fun findByCreditCode(creditCode: UUID): Credit {
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not found"))
        return if (credit.customer?.id === customerId) credit else throw RuntimeException("Contact admin")
    }

}