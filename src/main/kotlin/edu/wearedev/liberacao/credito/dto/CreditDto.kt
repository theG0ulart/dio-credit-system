package edu.wearedev.liberacao.credito.dto

import edu.wearedev.liberacao.credito.entity.Credit
import edu.wearedev.liberacao.credito.entity.Customer
import edu.wearedev.liberacao.credito.util.validator.ValidDayFirstInstallment
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    @field:NotNull(message = "Não pode ser null") val creditValue: BigDecimal,
    @field:Future(message = "Data tem que ser futura") @field:ValidDayFirstInstallment val dayFirstInstallment: LocalDate,
    @field:Max(48)val numberOfInstallments: Int,
    @field:NotNull val customerId: Long
) {


    fun toEntity(): Credit = Credit (
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
