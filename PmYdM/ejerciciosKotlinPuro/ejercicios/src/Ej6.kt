data class Persona(val nombre:String, val edad:Int){
    override fun toString(): String {
        return "Persona(nombre='$nombre', edad=$edad)"
    }
}
fun main(){
    val persona=Persona("Juan",23);
    println(persona)
}