/**
 * Calculates the average (mean) of a set of numbers.
 * @param {number[]} heights - Array of numbers representing heights.
 * @returns {number} - The average value of the array.
 */
function average(heights) {
    let accumulator = 0; 
    const arrayLength = heights.length; //Total number of elements in the array.

    for (let i = 0; i < arrayLength; i++) {
        accumulator += heights[i]; //Adds the current height value to the accumulator.
    }

    return accumulator / arrayLength; //Divides the total sum by the number of elements to get the average.
}

/**
 * Computes the variance of a set of numbers
 * Variance measures the dispersion of data points relative to the mean
 * @param {number[]} numbers - Array of numbers for which variance will be calculated
 * @param {number} mean - The mean (average) value of the numbers
 * @returns {number} - The variance of the dataset
 */
function varianceFnc(numbers, mean) {
    let accumulator = 0; 
    const numbersSize = numbers.length;

    //Iterates through the array to calculate the sum of squared differences
    for (let i = 0; i < numbersSize; i++) {
        accumulator += (numbers[i] - mean) ** 2; 
    }

    return accumulator / numbersSize; 
}

//Sample data: heights in millimeters
const heights = [600, 470, 170, 430, 300];

//Compute variance and standard deviation
const variance = varianceFnc(heights, average(heights));
console.log("Standard Deviation:", Math.sqrt(variance)); //The compute of the standard deviation is the square root of the variance
