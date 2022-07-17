import java.text.SimpleDateFormat
import java.util.Date


class TransaccionMO(var saldo:Float = 0f, var importe:Float  = 0f) {
    private var saldoCuenta:Float = saldo
    private var valorOperacion:Float = importe
    private var fecha = hoy()


    fun getSaldoCuenta():Float{
        return saldoCuenta
    }
    fun setSaldoCuenta(saldo: Float){
        saldoCuenta = saldo
    }
    fun getValorOperacion():Float{
        return valorOperacion
    }
    fun setValorOperacion(miImporte: Float){
        valorOperacion = miImporte
    }
    fun setFecha(mifecha:String){
        fecha = mifecha
    }
    fun getFecha():String{
        return fecha
    }


    private fun hoy() = SimpleDateFormat("dd/M/yyyy").format(Date())
    //No se trabajar con fechas, aunque ahora no lo necesito

}