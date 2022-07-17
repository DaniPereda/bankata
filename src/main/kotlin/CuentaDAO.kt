class CuentaDAO {
    var archivoGuardado: MutableList<String> = recuperarArchivo()

    private fun recuperarArchivo():MutableList<String>{
        var returned: MutableList<String> = mutableListOf()
        returned.add("16/11/2021:100:100")
        returned.add("25/11/2021:-50:50")
        returned.add("06/12/2021:10.35:60.35")
        returned.add("01/05/2022:200:260.35")

        return returned
    }

    fun cargarTransacciones():CuentaMO
    {
        var miCuenta = CuentaMO()
        for (item in archivoGuardado){
            var nuevaTransaccionMO = TransaccionMO()     /// POR QUÉ LO TENGO QUE DECLARAR DENTRO DEL FOR PARA QUE FUNCIONE??
            var transaccionArray = item.split(':')
            nuevaTransaccionMO.setFecha(transaccionArray[0])
            nuevaTransaccionMO.setValorOperacion(transaccionArray[1].toFloat())
            nuevaTransaccionMO.setSaldoCuenta(transaccionArray[2].toFloat())

            miCuenta.transacciones.add(nuevaTransaccionMO)

        }

        return miCuenta

    }

    fun guardarTransaccion(transaccionMO: TransaccionMO){
        guardarTransaccionFormateada(formatearTransaccion(transaccionMO))
    }

    fun formatearTransaccion(transaccionMO: TransaccionMO):String{
        return transaccionMO.getFecha() + ':' + transaccionMO.getValorOperacion().toString() + ':' + transaccionMO.getSaldoCuenta().toString()
    }

    fun guardarTransaccionFormateada(transaccionFrormateada:String){
        archivoGuardado.add(transaccionFrormateada)
    }



}