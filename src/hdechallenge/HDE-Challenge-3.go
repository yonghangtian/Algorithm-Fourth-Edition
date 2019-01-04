/*
We want to calculate a sum of squares of some integers, excepting negatives
The first line of the input will be an integer N (1 <= N <= 100)
Each of the following N test cases consists of one line containing an integer X (0 < X <= 100), followed by X integers (Yn, -100 <= Yn <= 100) space-separated on the next line
For each test case, calculate the sum of squares of the integers excepting negatives, and print the calculated sum to the output. No blank line between test cases
(Take input from standard input, and output to standard output)
/*
{
    “github_url”: "https://gist.github.com/yonghangtian/c4dba348ad3267e1798a29104b9dfb25",
    "contact_email": "yonghangtian@gmail.com"
}
*/



package main

import (
    "fmt"
    )

func sum(n int) int {
    if n == 0 {
        return 0
    }
    var x int
    fmt.Scanf("%d", &x)
    if x < 0 {
        return sum(n - 1)
    } else {
        return sum(n - 1) + x * x
    }
}
func process(testcase int) {
    if testcase == 0 {
        return
    }
    var n int
    fmt.Scanf("%d", &n)
    fmt.Printf("%d\n", sum(n))
    process(testcase-1)
}
func main() {
    var testcase int
    fmt.Scanf("%d", &testcase)
    process(testcase)
}
