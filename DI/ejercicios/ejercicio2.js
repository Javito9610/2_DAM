const nota= 8;
switch (true){
    case nota<5:
        console.log("Suspenso");
        break;
    case nota<7:
        console.log("Aprobado");
        break;
    case nota<9:
        console.log("Notable");
        break;
    case nota<=10:
        console.log("Sobresaliente");
        break;
    default:
     console.log("Nota no válida. Solo del 0 al 10");

}