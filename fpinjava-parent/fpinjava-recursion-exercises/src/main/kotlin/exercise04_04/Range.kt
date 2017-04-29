package exercise04_04

tailrec fun range(start: Int, end: Int, acc: List<Int> = listOf()): List<Int> {
	if (start >= end) return acc
	else return range(start + 1, end, listOf(*acc.toTypedArray(), start))
}
