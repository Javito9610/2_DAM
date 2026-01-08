fun clasificarNota(nota: Int):String{
    when(nota){
        in 0 until 5->return "Suspenso"
        5,6->return "Suficiente"
        7,8->return "Notable"
        9,10->return "Sobresaliente"
        else->return "Error"
    }
}
fun main(){
    println(clasificarNota(5))
}