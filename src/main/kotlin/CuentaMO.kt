class CuentaMO {
    var transacciones:MutableList<TransaccionMO> = mutableListOf()

    fun getSaldo():Float{
        if (transacciones.isNotEmpty()) {
        return transacciones.last().saldo
        }else{
            return 0f
        }
    }

}