# FactorialSolver

Have you ever seen a problem like the following? <b>"Find the smallest n such that n! ends in 290 zeros"</b>(HMMT, 2003). <b>Legendre's formula</b> can be used in such cases.I actually wrote some Java code to check it out.

The sample code answers the above question in two ways. One is a brute-force method: find the factorial in BigInterger and loop until the trailing 0 is 270. Programming would give the answer in an instant, but it is difficult for a human to compute.

The second method is using Lujandre's formula. Given any prime number p and a positive integer n, how many times n! can be divided by p is found by summing the decimal fraction (floor) of n divided by p to the i-th power.

$$v_p(n!)= \sum_{i=1}^{\infty} \biggl\lfloor\frac{n}{p^i}\biggl\rfloor$$

The program factors n into prime factors using an <b>elastothenes sieve</b> and stores the prime factors and the exponents to be determined by the Lejandre's formula in a two-dimensional array. Since the number of trailing 0s is equal to the number of times it can be divided by 5, so we can find the number for which <b>factorsAndExps[2][1]</b> is greater than or equal to 270.

We can confirm that the answer obtained by the above two methods is 1170 in both cases. This <b>LugendresFactorizer</b> class can calculate the power exponent of all prime factors, which would be useful for answering similar math quizzes. 

## External Links and References

The explanation in Japanese is provided in the following blog.
https://qiita.com/B3QP/items/7578688dec1d5e8d2e78

<b>Reference:</b><br>
HMMT.(2003) <i>Harvard-MIT Mathematics Tournament| March 15, 2003.</i><br>
https://hmmt-archive.s3.amazonaws.com/tournaments/2003/feb/alg/problems.pdf<br>
