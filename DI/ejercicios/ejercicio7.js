const edades = [12,18,25,8,40,16];
const mayoresEdad= edades.filter(num=>num>=18)

const mediaEdadesMas18=mayoresEdad.reduce((a,b)=>(a+b))/mayoresEdad.length
console.log(mayoresEdad);
console.log(mediaEdadesMas18)