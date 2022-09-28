// happy coding 👻
function isPrime(number:number):boolean {
    let isPrime = true;
    if (number < 2) {
        isPrime = false;
    }
    for(let i = 2; i < Math.sqrt(number);i++) {
        if (number % i == 0) {
            isPrime = false;
            break;
        }
    }
    return isPrime;
}

let array:number[] = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let sum = 0;
for (let temp of array) {
    if (isPrime(temp)) {
        sum += temp;
    }
}
console.log(sum);
