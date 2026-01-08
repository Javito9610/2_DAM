const numeros = [3,7,2,9,12,5];
//Necesitamos unas variables auxiliares:

//Mostrar el número mayor:

var numeroMayor=numeros[0];//Tomamos como referencia el primer elemento, creando una variable externa, para que la comparación sea en base a un elemento externalizado y no al elemento anterior, ya que solo tomaríamos como referencia dicho elemento y no nos servirá para el resto de elementos del array
for (var i=0; i<numeros.length;i++){
    if(numeros[i]>numeroMayor){
        numeroMayor=numeros[i];
    }
}
console.log(numeroMayor);

//Mostrar el número menor:
var numeroMenor=numeros[0];
for (var i=0; i<numeros.length;i++){
    if(numeros[i]<numeroMenor){
        numeroMenor=numeros[i];
    }
}
console.log(numeroMenor);