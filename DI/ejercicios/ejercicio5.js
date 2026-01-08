function esPar(num){
    if (num%2==0){
        return true
    }else{
        return false
    }
}

var numero=9;

if(esPar(numero)==true){
    console.log("Es par");
}else{
    console.log("Es impar");
}