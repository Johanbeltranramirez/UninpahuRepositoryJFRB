const heigths = [600, 470, 170, 430, 300]

function average (heights_puppies){
    /*
    This functions is used to  .....
    @heights_puppies  => E float,   0 <= heights_puppies <= 500  
    @ return 
    
    **/
    
    let acumulator = 0;
    const array_length =  heights_puppies.length; 
    
    for(let i=0; i< heights_puppies.length; i++){
        
        acumulator +=  heights_puppies[i];
    }
    
    return acumulator/array_length;
}
function varianceFnc(numbers, average){
    
    let acumulator = 0; 
    const numbersSize =  numbers.length; 
    
   for(let i=0; i< numbersSize; i++){
        
        acumulator = ((numbers[i] - average)**2) + acumulator;
    }
    
    return acumulator/numbersSize;
    
}

const variance = varianceFnc(heigths, average(heigths));
console.log("standard deviation: ", Math.sqrt(variance));
