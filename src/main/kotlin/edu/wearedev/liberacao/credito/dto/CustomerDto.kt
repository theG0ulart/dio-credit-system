package edu.wearedev.liberacao.credito.dto

import edu.wearedev.liberacao.credito.entity.Address
import edu.wearedev.liberacao.credito.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Insira o nome") val firstName: String,
    @field:NotEmpty(message = "Insira o sobrenome")val lastName: String,
    @field:CPF(message = "Insira o CPF") val cpf: String,
    @field:NotNull(message = "Insira o salario") val income: BigDecimal,
    @field:Email(message = "Insira o email") val email: String,
    @field:NotEmpty(message = "Insira o password") val password: String,
    @field:NotEmpty(message = "Insira o zipCode") val zipCode: String,
    @field:NotEmpty(message = "Insira a rua") val street: String
) {


    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
