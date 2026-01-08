fun operar(a:Int, b:Int, op:(Int,Int)->Int):Int=op(a,b)

fun main(){
    println(operar(1,2){x,y->x*y});
}