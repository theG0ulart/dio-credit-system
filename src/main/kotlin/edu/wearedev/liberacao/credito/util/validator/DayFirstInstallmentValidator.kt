package edu.wearedev.liberacao.credito.util.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDate

class DayFirstInstallmentValidator : ConstraintValidator<ValidDayFirstInstallment, LocalDate> {

    override fun isValid(value: LocalDate?, context: ConstraintValidatorContext): Boolean {
        if (value == null) {
            return true // Deixe @NotNull lidar com valores nulos
        }

        val now = LocalDate.now()
        val threeMonthsFromNow = now.plusMonths(3)

        return value.isAfter(now) && value.isBefore(threeMonthsFromNow)
    }
}
