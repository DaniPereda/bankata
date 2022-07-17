import kotlin.math.roundToInt

class BankBO {
    val pantalla: Pantalla = Pantalla()
    var miCuentaBO = CuentaBO()
    var miCuenta:CuentaMO = miCuentaBO.initCuenta()


    fun inicio(){
        var option:String = ""
        while (option != "5"){
            option = pantalla.menuInicial()

            if (opcionValida(option, "1", "5")){
                pantalla.msjOpcionElegida(option)

                when(option){
                    "1" -> print(verSaldo())
                    "2" -> ingresar()
                    "3" -> retirar()
                    "4" -> extracto()
                }

            }
            else{
                pantalla.escribe("OPCION NO VÁLIDA")
            }
            pantalla.msjContinuar()


        }
    }

    fun opcionValida(option:String, min:String="1", max:String="9"):Boolean
    {
        val regex = "[${min}-${max}]".toRegex()
        return option.matches(regex)
    }

    fun ingresar()
    {
        try{
            var cantidad:Float = (pantalla.recojeDato("Qué cantidad quieres ingresar?")).toFloat()

            operaTransaccion(cantidad, true)

            println(miCuenta.transacciones.last().getValorOperacion())  //REDONDEAR A DOS DECIMALES
        }catch(e:java.lang.NumberFormatException)
        {
            println("ERROR: Debes introducir un número")
        }


    }

    fun retirar()
    {
        try{
            var cantidad:Float = (pantalla.recojeDato("Qué cantidad quieres retirar?")).toFloat()

            if (isSaldo(cantidad)){
            operaTransaccion(cantidad, false)

            print(miCuenta.transacciones.last().getValorOperacion())  //REDONDEAR A DOS DECIMALES
            }else
            {
                pantalla.escribe("ERROR: Saldo insuficiente")
                pantalla.msjContinuar()
            }

        }catch(e:java.lang.NumberFormatException)
        {
            println("ERROR: Debes introducir un número")
        }


    }

    private fun operaTransaccion(cantidad:Float, isIngreso:Boolean){
        var cantidadConSigno = cantidad
        if(!isIngreso){
            cantidadConSigno *= -1
        }
        miCuentaBO.addTransaccion(miCuenta, cantidadConSigno)
    }

    fun verSaldo():Float = miCuenta.transacciones.last().getSaldoCuenta()

    fun extracto(){
        pantalla.msjLimpar()
        pantalla.escribe("el extracto de tu cuenta es:")
        pantalla.escribe("FECHA\t\t\t\tIMPORTE OPERACION\t\t\tSALDO TOTAL")
        miCuenta = miCuentaBO.initCuenta()
        for(trans in miCuenta.transacciones)
        {
            pantalla.escribe(trans.getFecha() + "\t\t\t" + trans.getValorOperacion() + "\t\t\t\t\t\t" + trans.getSaldoCuenta())

        }
    }

    fun isSaldo(importeARetirar:Float):Boolean = miCuenta.getSaldo() >= importeARetirar


}