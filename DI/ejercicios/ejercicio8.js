document.addEventListener("DOMContentLoaded", function(){
    const boton= document.getElementById("btn");
    const texto=document.getElementById("texto");
    boton.addEventListener("click", function(){
        texto.textContent="Texto nuevo.";
    })
})


