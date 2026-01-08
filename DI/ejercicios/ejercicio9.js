document.addEventListener("DOMContentLoaded", function(){
    const sumar= document.getElementById("sumar");
    const restar= document.getElementById("restar");
    let contador= document.getElementById("contador");
    let contentContador= contador.textContent;
    let contentContadorNum=Number(contentContador);

    sumar.addEventListener("click", function(){
       contador.textContent=contentContadorNum++;
    })

    restar.addEventListener("click", function(){
        contador.textContent=contentContadorNum--;
    })

    
})