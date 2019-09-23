# nasneba
Nasneba Developer Pre-Test 2019

## Question 1
Let *p* be the first input array and *q* be the second input array. The method construct a bucket by iterating *p* then check the *q* existance by iterating *q* and check against with the bucket. Thus the running time is *O(|p| + |q|)*

## Question 2
Cache is backed by HashMap. `Cache.get(key)` get the value and refresh its last access time if it is not null. Return -1 is it is null.
`HashMap.get(key)` is constant time. `CacheEntry.refresh()` is constant time. `return -1` is constant time. Therefore `get(key)` is *O(1)*.


## Question 3
Functions return by `createArrayOfFunctions()` whould share the same `i`, causing the those functions would giving the same reuslt under the same input value `x`. This is closure feature in javascript. Declare `i` using `let` instead of `var` would solve this issue since it will be limited in `createArrayOfFunctions()` local scope.

```javascript
function createArrayOfFunctions(y) {
  var arr = [];
  for (let i = 0; i < y; i++) {
    arr[i] = function(x) {
      return x + i;
    }
  }
  return arr;
}
```

## Question 4
Refer to `src\main\java\com\nasneba\devtest\question4\Fibonacci.java`