// Roma, 20-03

/* function reverseNumber(num)
{    
    let result = 0;
    let cifra_estratta;
    
    while(num > 0) { 
        cifra_estratta = num % 10; 
        num = Math.floor(num / 10);
        result = (result * 10)+ cifra_estratta;
    } 
    return result;
}      

console.log(reverseNumber(256)) */

/* 
function bubbleSort(arr)
{
    let temp;
    let sorted = false;
    while(sorted == false) {
        sorted = true;
        for(let i = 0; i < arr.length; i++)
        {
            if (arr[i] > arr[i+1]) 
            {
                console.log('ho effettuato uno scambio')
                temp = arr[i]; 
                arr[i] = arr[i+1];
                arr[i+1] = temp; 
                sorted = false;
            }
        }
    }
    return arr;
}

const arr = [10,2,15,7,9,20];
console.log(bubbleSort(arr))
*/

// ESERCIZI POMERIGGIO


// 1. Calcolare l'ipotenusa di un triangolo rettangolo di cateti 3 e 4. 
//Potete usare Math


/* let a = 3;
let b = 4;

function ipotenusa(a,b) {
    
    return Math.sqrt(a * a + b * b);
    
}

console.log(ipotenusa(a,b)) */

// 2. scrivere una funzione che trasformi un nome nelle sue iniziali "Tizio Caio" => T.C.

/* METODO 1 
function onlyCapital(str)
{
    let onlyCaps = "";
    for (let i = 0; i < str.length; i++) {
        if(str[i].match(/[A-Z]/))
        {
            onlyCaps += str[i];
        }
    }
    return onlyCaps;
}
console.log(onlyCapital("Desirée Totaro")) */

/* METODO 2 

function onlyCapital(str)
{
    let result = "";
    let splitted = str.split(" ")
    for (let i = 0; i < splitted.length; i++) {
        result += splitted[i][0] + '.'        
    }
    return result;
}

console.log(onlyCapital("Desirée Totaro"))
*/


// 3. scrivere una funzione che , dati 3 numeri, ritorni true se questi 3 numeri possono formare un triangolo. False altrimenti

/* function canBeATriangle(a,b,c)
{
    
    if (a < (b + c) && a > (b - c) && b < (a + c) && b > (a - c) && c < (a + b) && c > (a - b)) 
    {
        return true
    } 
    else 
    {
        return false;
    }
}

console.log(canBeATriangle(3,2,3))  */

/* METODO 2

function isTriangle(a,b,c)
{
    if (check(a,b,c) && check (b,c,a) && check(c,b,a))
    { return true } else { return false }
}

function check(num1, num2, num3) 
{
    return num1 > Math.abs(num2-num3) && (num1 < num2 + num3)
}

console.log(isTriangle(3,2,3))
*/

// 4. congettura di Collatz: preso un numero maggiore di 1, se questo è pari dividerlo 
// per due, se dispari moltiplicarlo per 3 e aggiungere 1. Ripetere. Qualunque sia il 
// numero di partenza, l'algoritmo termina sempre ad uno. Scrivere una funzione che 
// implementi l'algoritmo e ritorni un array con il valore calcolato ad ogni iterazione


/* function getCollatzed(num) {
    let arr = [num];
    if(num <= 1){
        console.log('Il numero è minore di 1');
    }
    while (num > 1) {
        if(num % 2 == 0) {
            num = num / 2;
        } else {
            num = num * 3 + 1;
        }
        arr.push(num)
    }
    return arr;
}

console.log(getCollatzed(5)) */

// 5. Scrivere una funzione che, assegnato un numero n, ritorni la successione di 
// fibonacci fino al numero n sottoforma di array.
// Ad esempio 3 => [1,1,2], 9 => [1,1,2,3,5,8,13,21,34]

/* function fibonacci(num) {
    let fib = [];
    let x = 0;
    let y = 1;
    let z;
    
    fib.push(x);
    fib.push(y);
    
    let i = 2;
    while (i < num) {
        z = x + y;
        x = y;
        y = z;
        
        fib.push(z);
        i = i + 1;
    }
    return fib;
}

let num = 9;
fib = fibonacci(num);

console.log(fib); */

//6.scrivere una funzione che, assegnato un numero n, ritorni se è primo

/* function primeNumbers(number)
{
    if ( number == 1 || number == 2 ) {
        return true;
    }
    for ( let i = 2; i < number; i++ ) {
        if ( number % i == 0 ) {
            return false;
        }
    } 
    return true;
};

console.log(primeNumbers(7)) */

// 7.scrivere una funzione che assegnata una stringa ritorni la somma delle cifre in essa presenti.
// Ad esempio "Sono 1 stringa di 6 parole" => 7

/* function checkNumbers(str)
{
    let sum = 0;
    let newStr = "";
    for (let i = 0; i < str.length; i++) {
        if (str[i].match(/\d+/)) 
        {
            sum = sum + parseInt(str[i])
        }
    }
    return sum;
}

console.log(checkNumbers("C1ao a tutt1")) */

// 8. scrivere una funzione che trasformi un numero in ore e minuti. Ad esempio 3014 => 50:14. 
// Devono essere sempre presenti due cifre, sia per le ore che per i minuti

/* let num = 3014
let ore = Math.floor(num/60)
let minuti = Math.floor(num % 60)
console.log(ore + ":" + minuti) */

// 9. scrivere una funzione che, assegnata una stringa, ritorni l numero di vocali presenti. 
//Gestire le maiuscole

/* function contaVocali(str)
{
    let vocali = "aeiouAEIOU"
    let counter = 0;
    for (let i = 0; i < str.length; i++) {
        if(vocali.includes(str[i]))
        {
            counter++ 
        }       
    }
    return counter;
}

console.log(contaVocali("Ciao a tutti amicii")) */

// 10. scrivere una funzione che accetta una stringa e restituisce la parola più lunga

/* function longestWord(str) {
   let splitted = str.split(" ");
   let longest = "";
   for (let i = 0; i < splitted.length; i++) {
    if(splitted[i].length > longest.length)
    {
        longest = splitted[i];
    } 
   }
   return longest;
}

console.log(longestWord("Ciao a tutti amicissimi"))
 */

// 11. scrivere una funzione che accetti una stringa contenente solo caratteri 
// x e y e ritorni true se il numero delle x è uguale al numero delle y

/*  function onlyXandY(str)
{
   let x = 0;
   let y = 0;

   
    for (let i = 0; i < str.length; i++) {
        if (str[i] == "x" || str[i] == "X")
        {
            x++;
        } else if (str[i] == "y" || str[i] == "Y")
        {
            y++;
        } else
        {
            return "Non sono consentite queste lettere";
        }      
    }
    return x === y;
}

console.log(onlyXandY("xyxyx")) */

// Roma, 21 - 03 Lezione

//! funzioni
//! un blocco di codice che compie delle azioni, ritorna un risultato, che può essere riutilizzato.

//* DRY
// let somma = 10 + 20;
// let somma2 = 20 + 40;
// let somma3 = 40 + 50;

//! astrarre -> prendere tutto ciò che si ripete in determinate operazione e crearne una funzione
// let num1 = 20;
// let num2 = 10;
//* let somma = num1 + num2;

//* dichiarazione di funzione ( insieme di istruzioni )
// function somma(num1, num2){ //! => parametri formali
//     //! istruzioni
//     return num1 + num2;
// }
// console.log(somma(10, 20)); //! chiamata a funzione => parametri reali ( attuali )
// console.log(somma(7, 2));

//! SCOPE
//* dove esiste la variabile
//* dove possiamo visualizzare il valore della variabile
//* ambito di visibilità
//* è il blocco di codice in cui è visibile una variabile

// let x = 5;
// function stampax(){
//     //! NON HO DICHIARATO UNA VARIABILE CON NOME x.
//     //? la variabile x non esiste
//     console.log(x);
//     let y = 5;
// }
// stampax();
// console.log(y);

//! dichiarazionei di funzione
//* function declaration e function expression
//! function declaration
// function sayHi() { console.log("hello"); }

//* le funzioni in JS si comportano come dei valori
//! function expression
// let sayHi = function(){
//     console.log('ciao');
// }
// console.log(sayHi);
// sayHi();


// function sayHi() { console.log('hello'); }
// let fun = sayHi;
// sayHi();
// fun();
// console.log(typeof fun)

//! passare le funzioni come dati ad altre funzioni => callback
//* creiamo una funzione che fa una domanda. A questa funzione passiamo altre due funzioni. una verrà eseguita se confermiamo ( se rispondiamo si alla domanda), l'altra verrà eseguita se rispondiamo no alla domanda
// ask(question, ifYes, ifNo);

// function ask(question, yes, no){
//     if(confirm(question)){
//         yes();
//     }
//     else {
//         no();
//     }
// }

// function ifYes() { console.log("Hai confermato"); }
// function ifNo() { console.log("Hai rifiutato"); }
// ask("é chiaro?", ifYes, ifNo);

//* abbiamo passato ad una funzione due funzioni come valori
//* le funzioni passate come valori possono essere invocate all'interno della funzione
//* CALLBACK -> FUNZIONE CHE PUò ESSERE CHIAMATA DOPO
// function ifYes2() { console.log("Complimenti!")}
// function ifNo2() { console.log("Torna a studiare!")}
// // ask("Hai capito le callback?", ifYes2, ifNo2);
// ask(
//     "Hai capito le callback?",
//     () => console.log('bravo'),
//     () => console.log("torna a studiare")
// )
// [].filter( (el) => console.log(el) )

//! differenza tra function expression e function declaration
//* la function declaration rende la funzione richiamabile in qualsiasi punto del programma
// function sayHi(){
//     console.log('ciao');
// }
// sayHi();

//* function expression rende la funzione richiamabile solo dopo la sua dichiarazione
// sayHi();
// let sayHi = function () { console.log("ciao"); }

//! compilato just in time
//! ->  assunzioni

//! genera un bytecode ( codice direttamente eseguibile dal processore ) con l'isstruzione che stampa il valore 5
// function prendiinumeripari(arr){
//     return arr.filter( el => el % 2 == 0 );
// }
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7]);
// prendiinumeripari([1,2,3,4,5,6,7,8]);

// let nomefunzione = (arg1, arg2, ..., argn ) => espressione;
// let sum = (num1, num2) => num1 + num2;

//! Funzioni di ordine superiore
//* astrarre l'operazione di moltiplicazione

//* GENERALIZZAZIONE DEI DATI
//* abbiamo dichiarato dei segnaposto solo per i dati ( non per il comportamento )
// function multiplyBy2(n) { return n * 2; }
// function multiplyBy3(n) { return n * 3; }
// function multiplyBy4(n) { return n * 4; }

// function multiplyBy(n, m) { return n * m; }

//* voglio creare una funzione che prenda un numero e lo moltiplichi per un altro numero
// function multiply1By2 () { return 1 * 2; }
// function multiply1By3 () { return 1 * 3; }
// function multiply1By4 () { return 1 * 4; }

//* generalizzare i dati
// function multiplyNByM(n, m) { return n * m; }

// function doubleAndLog(num){
//     const double = num * 2;
//     console.log(`il nuovo numero è ${double}`);
// }
// function divideAndLog(num){
//     const half = num / 2;
//     console.log(`il nuovo numero è ${half}`)
// }
// function sumThreeAndLog(num){
//     const summed = num + 3;
//     console.log(`il nuovo numero è ${summed}`)
// }


// function changeAndLog(num, istruzioni){
//     const changed = istruzioni(num);
//     console.log(`il nuovo numero è ${changed}`);
// }

// const double = x => x * 2;
// const divide = x => x / 2;
// const sumThree = x => x + 3;

// changeAndLog(3, double);//* callback
// changeAndLog(3, divide);//* callback
// changeAndLog(3, sumThree);//* callback

//* funzione di ordine superiore ( funzione che accetta come parametro una funzione e che può anche ritornare una funzione )
//! alla variabile incrementatore viene assegnato una funzione che restituisce un'altra funzione
// let incrementatore = function(incremento){
//     return function(valore){
//         return incremento + valore;
//     }
// }

// // console.log(incrementatore);
// let incrementadicinque = incrementatore(5);
// console.log(incrementadicinque(4));
// let counter = 1;
// function outer(){
//     //* questo valore è vivo, è presente in memoria
//     let counter = 1;
//     function incrementCounter(){
//         console.log(counter)
//         return counter++;
//     }
//     return incrementCounter;
// }
// const newFunction = outer();
// newFunction();
// newFunction();
// newFunction();
// newFunction();
// newFunction();
// newFunction();
// newFunction();
// console.log(counter);
//* SCOPE CHAIN : la catena dei blocchi aperti.
//! V1. la funzione visualizzasaluto NON esce dallo scope della funzione saluta
// let saluto = "buongiorno";
// function saluta(persona){
//     let fullname = persona.nome + " " + persona.cognome;
//     function visualizzasaluto(){
//         console.log(saluto + " " + fullname);
//     }
//     visualizzasaluto();
// }
// saluta({nome: "Pippo", cognome: "Disney"});
// visualizzasaluto();

//! V2 la funzione visualizzasaluto ESCE dallo scope della funzione saluta
// let saluto = "Buongiorno";
// function saluta(persona){
//     let fullname = persona.nome + " " + persona.cognome;
//     return function () {
//         console.log(saluto + ' ' + fullname);
//     }
// }
// let visualizzaSaluto = saluta({nome: "Pippo", cognome: "Disney"});
// visualizzaSaluto();

//! ARRAY
//* un contenitore ordinato ( tramite indice ) di valori
//* un tipo non primitivo => UN OGGETTO LA CUI FIRMA è PRESENTE GIà NEL LINGUAGGIO
//* 0 based => perché l'indicizzazione parte da 0

// let arr = [];
// let arr = new Array(); //! genera array vuoto
// let arr = new Array("ciao", 3, {name: "Pippo"});
// console.log(arr);
//! push, pop, split
// let arr = [1,2,3,4,5,6,7];
//! filter, map, reduce
//! filter -> filtra l'array in base ad una callback
// const filtered = arr.filter( x => x > 3 );
//! 1 => 1 => 1 > 3 => false
//! 2 => 2 => 2 > 3 => false
//! 4 => 4 => 4 > 3 => true
// console.log(filtered);

//! map -> crea un nuovo array in cui applica, ad ogni elemento una callback e ritorna il risultato
// const mapped = arr.map( el => el * 2);
// console.log(mapped)

//! reduce -> restituisce un valore che viene calcolato in base ad un riduttore e ad una operazione
// const summed =
//     arr.reduce( (acc, valore_corrente) => {
//         let chiave =`${'valore_corrente' + valore_corrente}`;
//         console.log(acc, chiave)
//         return {...acc, chiave : valore_corrente}
//     }, {});
// console.log(summed);

// function reduce(arr){
//     let acc = 0;
//     for(const number of arr){ acc = acc + number; }
//     return acc;
// }
// console.log(reduce(arr));

//! data una stringa con dei nomi, ritornare le iniziali
// function iniziali(string){
//     //! per ogni stringa devo accedere al primo elemento
//     //! devo concatenare il .
//     //! la devo ritornare
//     let result = string.split(' ')
//                     .map(el => el[0]+'.')
//                     .join('');
//     return result;
// }
// console.log(iniziali("Tizio Caio"));

//! scrivere una funzione che assegnata una stringa ritorni la somma delle cifre in essa presenti. Ad esempio "Sono 1 stringa di 6 parole" => 7
// function stringSum(string){
//     //? prendere solo i numeri
//     //? sommarli
//     //? ritornarli
//     return string.split('')
//                 .filter( char => Number(char) )
//                 .reduce( (acc, val) => Number(acc) + Number(val)); //! somma
// }

// console.log(stringSum("Sono 1 stringa di 6 parole"))


//! gestire un array senza ripetizioni
// let arr = [];
// let student1 = "Andrea";
// let student2 = "Cosimo";
// let student3 = "Gianvito";
// let student4 = "Andrea";
// arr.addElement = function(newStudent){
//     if(!this.includes(newStudent)){
//         this.push(newStudent);
//     }
// }
// arr.addElement(student1);
// arr.addElement(student2);
// arr.addElement(student3);
// arr.addElement(student4);
// console.log(arr);
//* SET -> un insieme di elmenti che non contiene ripetizioni
// let mySet = new Set();
// //! add
// mySet.add(1);
// mySet.add(2);
// mySet.add("tre");
// mySet.add("tre");
// // console.log(mySet.has('tre'));
// mySet.delete(1);
// console.log(mySet);

// let arr = Array.from(new Set([1, 2, 3, 3, 3, 4, 5]));
// console.log(arr)


//* MAP
//* lista di coppie chiave: valore

// let myMap = new Map();
// myMap.set("nome", "andrea");
// myMap.set(3.14, "Pi Greco");
// myMap.set(3.14, "Pi Turco");
// let obj = {name: "Pippo", age: 72};
// myMap.set(obj, "Pippo oggetto")
// console.log(myMap)
// let player1 = {name: "Ciccio1984"};
// let player2 = {name: "Giacomino1976"};
// let map = new Map();
// map.set(player1, [{name: "m16", bullets: 670, color: "red"}]);
// map.set(player2, [{name: "1911", bullets: 45, color: "black"}]);

// for(let key of map.keys()){
// console.log(map.get(key))
// }

// let game = {
//     players: new Map(),
//     addPlayer: function (key, value){
//         this.players.set(key, value);
//     }
// }

// let player1 = {
//     name: "ciccio",
//     lifePoints: 100,
//     guns: [
//         {name: "m16", bullets: 670, color: "red"},
//         {name: "1911", bullets: 45, color: "black"}
//     ],
//     attack: function(otherPlayer){
//         otherPlayer.lifePoints -= 200;
//         if(otherPlayer.lifePoints < 0){
//             game.players.delete(otherPlayer.name);
//         }
//     }
// }

// let player2 = {
//     name: "pippo",
//     lifePoints: 100,
//     guns: [
//         {name: "m16", bullets: 670, color: "red"},
//         {name: "1911", bullets: 45, color: "black"}
//     ],
//     attack: function(otherPlayer){
//         otherPlayer.lifePoints -= 20;
//     }
// }

// game.addPlayer(player1.name, player1);
// game.addPlayer(player2.name, player2);
// console.log(game.players);
// game.players.get(player1.name).attack(player2);
// console.log(game.players)

//* scrivere una funzione che accetta una stringa e restituisce la parola più lunga
// function longest(string){
//     let longest = '';
//     //! ciclare su tutte le singole parole e controllare quale di queste parole è la più lunga
//     let splitted = string.split(' ');
//     for (let i = 0; i < splitted.length; i++) {
//         if(splitted[i].length > longest.length){
//             longest = splitted[i];
//         }
//     }
//     return longest;
// }

// function longest(string){
//     // return string.split(' ')
//     //             .sort( (a, b) => a.length - b.length)
//     //             .pop();
//     return string.split(" ")
//         .reduce((longest, word) => {
//             return word.length > longest.length ? word : longest;
//         }, "");


// }
// console.log(longest("Sono una stringaaaaaaaaaaa lunghissima sdfidsfhksdjfhglskdjfg"))
//! scrivere una funzione che accetti una stringa contenente solo caratteri x e y e ritorni true se il numero delle x è uguale al numero delle y
// function xy(string){
//     let numberOfx = 0;
//     let numberOfy = 0;
//     for (let i = 0; i < string.length; i++) {
//         if(string[i] == 'x'){
//             numberOfx++;
//         } else {
//             numberOfy++;
//         }
//     }
//     return numberOfx == numberOfy;
//     // if(numberOfx == numberOfy) return true;
//     // return false;
// }

/* function xy(string){
    // ! inline variables
    return string.split('').filter(el => el == 'x').length == string.split('').filter(el => el == 'y').length;
}
console.log(xy("xxyy")) */

// Roma, 22 - 03
/* function persona(name, surname)
{
    this.name = name;
    this.surname = surname;
    this.email = name + '.' + surname + '@gmail.com'
    this.mostranome = function() { console.log(`${this.name}`) }                                     
}

const p1 = new persona("Desi", "Totaro")
console.log(p1) */

// ESERCIZI POMERIGGIO

//Object literal
/* let persona = {
    'name' : 'Desirée',
    'surname' : 'Totaro',
    'age' : 24,
    'subject' : [
      { 'linguaggio' : 'JavaScript', 'tipo' : 'Full-Stack'},
      { 'linguaggio' : 'Java', 'tipo' : 'Back-End'},
      { 'linguaggio' : 'PHP', 'tipo' : 'Back-End'}
    ], 
    'stampaNome': function()
    {
        console.log(`Ciao, io sono ${this.name} e ho ${this.age} anni`)
    },
    'stampaSubject' : function()
    {
        this.subject.forEach( materia => console.log(`${materia['linguaggio']} (${materia['tipo']})`))
    }
}

for(key in persona){
     console.log(persona[key])
 }
    
persona.stampaNome()
persona.stampaSubject()  */

// CLONE 

/* let user = { name: "Desi", surname : "Totaro", age : 24, fiscalCode: "TTRDSR"}
function calcolaCose(user)
{
    let clone = {};
    Object.assign(clone,user); 
}
 */

//CLASSI

/* let currentUserIsAdmin = true; 
class Person {
    
    #name;
    #surname;

    constructor(name, surname){
        this.setName(name)
        this.setSurname(surname)
    }

    getName()
    {
        if(currentUserIsAdmin) return this.#name;
        return "Non puoi vedere il nome!";
    }

    
    getSurname()
    {
        if(currentUserIsAdmin) return this.#surname;
        return "Non puoi vedere il cognome!";
    }

    setName(value)
    {
        if(value == "") { throw Error('Non puoi inserire stringa vuota!') }
        this.#name = value
    }

    setSurname(value)
    {
        if(value == "") { throw Error('Non puoi inserire stringa vuota!') }
        this.#surname = value
    }

}

const person1 = new Person("Desi", "Totaro")
/* const person2 = new Person("Luca", "Rossi")
const person3 = new Person("Marco", "Bianchi") */
//console.log(person1.name) >> UNDEFINED */

// PROXY
/* let persona = {
    name : "",
    surname : "",
}

let loggedUser = {
    isAdmin: false
}


let proxy = {

    get(target, propertyName) {
        if(loggedUser.isAdmin) { 
        console.log("stai provando ad accedere all'attributo" + propertyName)
        return target(propertyName)
        }
      throw Error("Non puoi passare!")
    },


    set(target, propertyName, value) {
        console.log("Stai provando a modificare la proprietà" + propertyName)
        if(value == "")
        {
            throw Error("Non puoi!")
        }
        target[propertyName] = value;
    }
}

let personaProxata = new Proxy(persona, proxy)
console.log(personaProxata.name)
 */
