
function sumFibonace(count:number):number  {
    let firtNumber:number=0;
    let secondNumber:number=1;
    let sum:number=firtNumber+secondNumber;
    let result:string =secondNumber+" ";
    for (let i = 0;i<count;i++){
        let thirdNumber = firtNumber+secondNumber;
        firtNumber = secondNumber;
        secondNumber  = thirdNumber;
        result+=thirdNumber+" ";
        sum+=thirdNumber;
    }
    console.log(result);
    return sum;
}
console.log(sumFibonace(10));
