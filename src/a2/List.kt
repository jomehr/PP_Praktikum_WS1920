package a2

sealed class List<T> {

    class Node<T>(val head: T, val tail: List<T>) : List<T>() {
        override fun toString() = "${head.toString()} , ${tail.toString()}"
    }

    object Nil : List<Nothing>() {
        override fun toString() = "NIL"
    }

    companion object {
        operator fun <T> invoke(vararg values: T): List<T> {
            var empty = Nil as List<T>

            return values.foldRight(empty, { v, l -> l.addFirst(v) })
        }
    }

    fun addFirst(head: T): List<T> = Node(head, this)

    fun removeFirst(): List<T> = when (this) {
        is Nil -> throw IllegalStateException()
        is Node<T> -> this.tail
    }
}




