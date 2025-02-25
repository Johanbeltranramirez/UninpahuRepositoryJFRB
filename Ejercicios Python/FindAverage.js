/**
 * Calculates the average (mean) of an array of numbers
 * @param {number[]} heights_puppies - Array of numbers representing heights
 * @returns {number} - The average value
 */
function average(heights_puppies) {
    let accumulator = 0;
    const arrayLength = heights_puppies.length;

    for (let i = 0; i < arrayLength; i++) {
        accumulator += heights_puppies[i];
    }

    return accumulator / arrayLength;
}

/**
 * Computes the variance of an array of numbers
 * @param {number[]} numbers - Array of numbers
 * @param {number} mean - The mean (average) value of the numbers
 * @returns {number} The variance of the numbers
 */
function varianceFnc(numbers, mean) {
    let accumulator = 0;
    const numbersSize = numbers.length;

    for (let i = 0; i < numbersSize; i++) {
        accumulator += (numbers[i] - mean) ** 2;
    }

    return accumulator / numbersSize;
}

//Sample data
const heights = [600, 470, 170, 430, 300];

//Compute variance and standard deviation
const variance = varianceFnc(heights, average(heights));
console.log("Standard Deviation:", Math.sqrt(variance));
