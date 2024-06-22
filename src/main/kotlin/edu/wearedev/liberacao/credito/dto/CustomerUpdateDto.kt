package edu.wearedev.liberacao.credito.dto

import edu.wearedev.liberacao.credito.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto (
    @field:NotEmpty(message = "Insira o nome")  val firstName: String,
    @field:NotEmpty(message = "Insira o sobrenome") val lastName: String,
    @field:NotNull(message = "Insira o salario") val income: BigDecimal,
    @field:NotEmpty(message = "Insira o zipCode") val zipCode: String,
    @field:NotEmpty(message = "Insira a rua") val street: String
) {
    fun toEntity(customer: Customer) : Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street

        return customer
    }
}
