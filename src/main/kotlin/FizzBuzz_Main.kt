import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    try{
        BankBO().inicio()
       // doFizzbuzz()  //Es mejor hacer esto como una funcion? O es un poco complicarlo gratuitamente i mejor poner aquí el for?
    }
    catch(e:Exception)
    {
        println("ERROR: $e")
    }
}

private fun doFizzbuzz(){
    for (item in 1..100) {
        println(item.toString() + " - " + transforma(item))
    }
}

private fun transforma(numero:Int) =  when{
       isFizz(numero) && isBuzz(numero) -> "FizzBuzz"
       isFizz(numero) -> "Fizz"
       isBuzz(numero) -> "Buzz"
       else -> numero.toString()
   }

private fun isFizz(miNumero:Int) = (miNumero%3 == 0)  //des d'un punt de vista de la legibilitat. És més el·legant com una variable o com una funció (p. ex isBuzz)

private fun isBuzz(miNumero:Int): Boolean{
    return (miNumero%5 == 0)
}

private fun isFizzBuzz(miNumero:Int): Boolean{
    //PODRIA SER MILLOR: return (isFizz(miNumero) && isBuzz(miNumero))
    return miNumero%15 == 0
}

