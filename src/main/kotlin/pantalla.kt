class Pantalla() {
    val lista_operaciones:List<String> = listOf("1.- CONSULTA DE SALDO", "2.- INGRESO", "3.- RETIRO", "4.- VER EXTRACTO COMPLETO", "5.- SALIR")

    fun menuInicial(): String {
        println("Bienvenido al Kata - Bank")
        println("Que puedo hacer por ti?")
        for (item:String in lista_operaciones){
            println(item)
        }
        println("\nEscribe el numero que corresponda a la opcion deseada: ")

        return readLine().toString()
    }

    fun msjOpcionElegida(op:String){
        msjLimpar()
        println("has elegido la opcion: ${lista_operaciones[op.toInt() - 1]}")
    }

    fun msjContinuar(){
        println("Pulsa intro para continuar")
        readLine().toString()
        msjLimpar()
    }

    fun msjLimpar(){
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n----------------------------------------------------")
    }

    fun escribe(mensaje:String)
    {
        println(mensaje)
    }

    fun recojeDato(mensaje:String):String{
        println(mensaje)
        return readLine().toString()
    }
}