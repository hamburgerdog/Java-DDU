import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

fun main() {
    val A = IntStream.range(1, 6).boxed().collect(Collectors.toList())
    val B: MutableList<Int> = ArrayList()
    println(A.toString())
    createArrayBFromA(A, B)
    println(B.toString())
}

fun createArrayBFromA(a: List<Int>, b: MutableList<Int>) {
    for (i in a.indices) {
        b.add(a.stream().filter { it != a[i] }
                .reduce(1) { it1, it2 -> it1 * it2 })
    }
}