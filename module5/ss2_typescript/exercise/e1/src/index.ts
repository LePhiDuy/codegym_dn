function fibonacci(n:number): number {
    if (n == 1 || n == 2) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
let sum = 0;
for (let i:number = 1; i <= 10; i++) {
    console.log(fibonacci(i) + " ");
    sum += fibonacci(i);
}
console.log("Tong 10 so fibonacci dau tien la " + sum);
