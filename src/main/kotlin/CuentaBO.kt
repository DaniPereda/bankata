class CuentaBO {
    var cuentaDAO = CuentaDAO()
    fun obtenerSaldo(cuenta:CuentaMO):Float{
        var returned = 0f
        if(cuenta.transacciones.isNotEmpty())
            returned =  cuenta.transacciones.last().getSaldoCuenta()

        return returned
    }

    fun initCuenta():CuentaMO{
        val miCuenta:CuentaMO = cuentaDAO.cargarTransacciones()
        return miCuenta
    }

    fun addTransaccion(cuenta:CuentaMO ,importe:Float){
        var nuevaTransaccion = TransaccionMO()
        nuevaTransaccion.setValorOperacion(importe)
        nuevaTransaccion.setSaldoCuenta(obtenerSaldo(cuenta) + importe)

        cuenta.transacciones.add(nuevaTransaccion)
        cuentaDAO.guardarTransaccion(nuevaTransaccion)

    }


 //   fun setTransacciones(){
 //       cuenta.transacciones.add(transacion)
 //   }
}