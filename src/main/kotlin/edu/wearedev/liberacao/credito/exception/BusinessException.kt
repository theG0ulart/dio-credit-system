package edu.wearedev.liberacao.credito.exception

data class BusinessException(override val message: String?) : RuntimeException(message) {

}
