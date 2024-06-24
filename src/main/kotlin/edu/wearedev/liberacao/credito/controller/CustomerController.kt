package edu.wearedev.liberacao.credito.controller

import edu.wearedev.liberacao.credito.dto.CustomerDto
import edu.wearedev.liberacao.credito.dto.CustomerUpdateDto
import edu.wearedev.liberacao.credito.dto.CustomerView
import edu.wearedev.liberacao.credito.entity.Customer
import edu.wearedev.liberacao.credito.service.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<CustomerView> {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView(savedCustomer))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<CustomerView> {
        val customer : Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto) : ResponseEntity<CustomerView>{
       val customer: Customer = this.customerService.findById(id)
       val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
       val customerUpdated: Customer = this.customerService.save(customerToUpdate)
       return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}