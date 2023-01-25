# Educational Codeforces Round 142

This is part of the solution to Educational Codeforces Round 142.

## Problem C

First, let's define a $pos$ array which satisfies the condition that $num_{pos_{i}} = i$. Basically, it means what's the position for number $i$ in the array $nums$.

Next, a very important observation is that the optimal strategy is operating $i$ and $n - i + 1$ together. Since our operation isto select two numbers and place the smaller one at the front and the bigger one at the end, if these two selected numbers are in symmetric positions in the sorted permutation, then we are closer to the destination. (This requires some thinking, but it's also the key to the question.)

Next, another very important obersation is that if $i, 1\le i \le \lfloor{\frac{n}{2}}\rfloor$ need to be operated, then all $1 \leq j \lt i$ will also be operated, which means we need at least $i$ operations. This one is easier to show. Since the operation will place $i$ at the front, after that, all $j$ that are smaller than $i$ will be place in front of $i$, so of course they need to be operated.

Consider what $i$ should be operated. There are two scenarios:

- $pos_{i} > pos_{n - i + 1}$: This means $i$'s position is larger than $(n-i+1)$'s. For example, $2\ \ 4\ \ 1\ \ 3$, $pos[1] \gt pos[4]$, so we should operate $1$ and $4$ together. In this case, we operate $i$ and $n - i + 1$ together.
- $pos_{i} \gt pos_{i-1}$ or $pos_{n-i+1} \lt pos_{n-i}$: This is considering neighboring symmetric pairs. An example for this would be $2\ \ 1\ \ 4\ \ 3 $ , $pos[1] \gt pos[2]$ and $pos[4] \lt pos[3]$. In this case, we operate $i-1$ and $n - i$ together.

The answer is the maximum between these two types of operations.