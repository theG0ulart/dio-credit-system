package edu.wearedev.liberacao.credito.dto

import edu.wearedev.liberacao.credito.entity.Credit
import edu.wearedev.liberacao.credito.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
   val creditValue: BigDecimal,
   val dayFirstInstallment: LocalDate,
   val numberOfInstallments: Int,
   val customerId: Long
) {


    fun toEntity(): Credit = Credit (
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
