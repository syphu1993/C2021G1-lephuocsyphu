function sumFibonace(count) {
    var firtNumber = 0;
    var secondNumber = 1;
    var sum = firtNumber + secondNumber;
    var result = secondNumber + " ";
    for (var i = 0; i < count; i++) {
        var thirdNumber = firtNumber + secondNumber;
        firtNumber = secondNumber;
        secondNumber = thirdNumber;
        result += thirdNumber + " ";
        sum += thirdNumber;
    }
    console.log(result);
    return sum;
}
console.log(sumFibonace(10));
