window.addEventListener("DOMContentLoaded",function(){

    let estaciones=["Primavera","Verano", "Otoño"];
    console.log(estaciones);
    let ultimaEstacion=estaciones.pop();
    console.log(ultimaEstacion);
    let primeraEstacion=estaciones.shift();
    console.log(primeraEstacion);
    estaciones.unshift(primeraEstacion);
    console.log(estaciones);
    let animalesMitologicos= ["dragon","grifo","gorgona", "minotauro"];
    console.log(animalesMitologicos);
    let otrosAnimalesMitologicos=["duende", "elfo", "cancerbero"];
    eliminarDosYTresYAgregarNuevos=animalesMitologicos.splice(1,2, otrosAnimalesMitologicos[0], otrosAnimalesMitologicos[1], otrosAnimalesMitologicos[2]);
    console.log(eliminarDosYTresYAgregarNuevos);
    console.log(animalesMitologicos);
    let copiaAnimalesMitologicosPosDosYTres= animalesMitologicos.slice(1,3);
    console.log(copiaAnimalesMitologicosPosDosYTres);
    animalesMitologicosString=animalesMitologicos.join("-");
    console.log(animalesMitologicosString);
    let arrayDeNuevo=animalesMitologicosString.split("-");
    console.log(arrayDeNuevo);
    let animalesMitologicosOrdenados=animalesMitologicos.sort();
    console.log(animalesMitologicos);
    let animalesMitologicosDosNuevos= ["sirena","triton"];
    let animalesMitologicosCompletos= animalesMitologicos.concat(animalesMitologicosDosNuevos);
    console.log(animalesMitologicosCompletos);
    animalesMitologicosCompletosReverse= animalesMitologicosCompletos.sort().reverse();
    console.log(animalesMitologicosCompletos);
    let posicionTriton= animalesMitologicosCompletos.indexOf("triton");
    console.log(posicionTriton);
     





})