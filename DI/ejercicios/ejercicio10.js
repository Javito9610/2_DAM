

document.addEventListener("DOMContentLoaded",function(){
    const formulario= document.getElementById("formulario"); //capturamos el nodo que contiene el formulario
    const input=document.getElementById("elementoLista"); //capturamos el nodo que contiene el input, elemento que introduce el usuario
    const lista= document.getElementById("listaElementos"); // lista en la cual vamos a añadir elementos
    formulario.addEventListener("submit", function(event){
        event.preventDefault(); // asi evitamos que se recargue la página cada vez que demos al boton de añadir elemento
        const elemento=input.value.trim(); // del nodo que capturamos, input, sacamos el valor de dicho nodo, el contenido que ha metido el usuario
        //trim acaba con los espacios al comienzo y al final.
        if (elemento!==""){// si el elemento del nodo input tiene valor:
            const li = document.createElement("li");//creamos un elemento de tipo "Elemento de lista (li)"
            li.textContent=elemento;// a ese elemento le damos el valor (o el contenido de texto) de la constante "elemento"
            lista.appendChild(li); //añadimos este li a "lista", que corresponde al nombre de la constante asignada a la etiqueta ul con id "elementoLista"
        
        }
    })
})