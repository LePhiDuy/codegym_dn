function fibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
var sum = 0;
for (var i = 1; i <= 10; i++) {
    console.log(fibonacci(i) + " ");
    sum += fibonacci(i);
}
console.log(`Tong 10 so fibonacci dau tien la ${sum}`);
