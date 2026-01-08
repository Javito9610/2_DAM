const arrayNum=[1,2,4,5];
const arrayAñadidio=[
    ...arrayNum.filter(num=>{if(num!==4 && num!==5){return true}else{return false}}),
    3,
    ...arrayNum.filter(num=>{if(num!==1 && num!==2){return true}else{return false}})
    ]
console.log(arrayNum)
console.log(arrayAñadidio)
/* Aunque huviera sido mejor asi:
    const arrayAñadidio=[
    ...arrayNum.filter(num=>num!==4 && num!==5),
    3,
    ...arrayNum.filter(num=>num!==1 && num!==2)
]
*/