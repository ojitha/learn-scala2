val lst = (1 to 5).toList
// add element to list
val updatedLst = lst :+ 6
// update the above list
val updatedLst2 = updatedLst.updated(0, 10)
// delete third element
val updatedLst3 = updatedLst2.patch(2, Nil, 1)
// drop till third element
val updatedLst4 = updatedLst3.drop(2)

// other operations:
// head: returns the first element of the list
val firstElement = lst.head
// tail: returns a new list containing all elements except the first
val allButFirst = lst.tail
// isEmpty: checks if the list is empty
val isEmptyList = lst.isEmpty
// contains: checks if an element exists in the list
val containsThree = lst.contains(3)
// filter: creates a new list with elements that satisfy a predicate
val evenNumbers = lst.filter(x => x % 2 == 0)
// map: transforms each element of the list
val squaredNumbers = lst.map(x => x * x)
// foldLeft: applies a binary operator to an initial value and all elements
val sumOfList = lst.foldLeft(0)((acc, x) => acc + x)
// reduceLeft: applies a binary operator to all elements (without initial value)
val productOfList = lst.reduceLeft((acc, x) => acc * x)
// take: returns the first n elements
val firstTwo = lst.take(2)
// takeWhile: returns elements as long as the predicate is true
val takeWhileLessThanFour = lst.takeWhile(_ < 4)
// dropWhile: drops elements as long as the predicate is true
val dropWhileLessThanFour = lst.dropWhile(_ < 4)
// distinct: returns a new list with duplicate elements removed
val listWithDuplicates = List(1, 2, 2, 3, 1)
val distinctList = listWithDuplicates.distinct
// reverse: returns a new list with elements in reverse order
val reversedList = lst.reverse
// sortWith: sorts the list based on a custom comparison function
val sortedList = List(3, 1, 4, 2).sortWith(_ < _)
// groupBy: groups elements into a map based on a discriminator function
val groupedByParity = lst.groupBy(_ % 2 == 0)