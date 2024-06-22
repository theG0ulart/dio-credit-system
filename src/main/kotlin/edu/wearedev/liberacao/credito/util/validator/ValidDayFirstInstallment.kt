package edu.wearedev.liberacao.credito.util.validator

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [DayFirstInstallmentValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidDayFirstInstallment(
    val message: String = "A data da primeira parcela deve ser maior que a data atual e menor que três meses",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
