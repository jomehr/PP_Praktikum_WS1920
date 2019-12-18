package a2

import a2.List.*

fun main () {

    //b)
    val product1 = Product("Apfel", 2.0, 3)
    val product2 = Product("Birnen", 40.0, 2)
    val product3 = Product("Kirschen", 200.0, 5)
    val product4 = Product("Salat", 3.0, 1)
    val product5 = Product("Tomaten", 10.0, 4)

    val list: List<Product> = List(product1, product2, product3, product4, product5)

    //1.
    val mapNames = map(list) {it.productName}
    println(mapNames)

    //2.
    val filterPrice = filter(list) {it.price > 10 }
    val mapNamesFilterPrice = map(filterPrice) {it.productName}
    println(mapNamesFilterPrice)

    //3.
    val mapPricier = map(list) {it.price * 1.19}
    println(mapPricier)

    //4.
    val filterRating = filter(list) {it.rating >= 3}
    val mapNamedFilterRating = map(filterRating) {it.productName}
    println(mapNamedFilterRating)

    //5.
    val replaceName = replaceIf(list, {Product("Angebot:"+it.productName, it.price, it.rating)}, {it.productName.startsWith("A") || it.productName.startsWith("B")})
    println(replaceName)

    //6.
    val anyPrice = any(list) {it.price > 100}
    val anyIt = anyIteration(list) {it.price > 100}
    println(anyPrice)
    println("test"+anyIt)

    //7.
    val foldSum = fold(list, 0.0, {total, next -> total + next.price})
    println(foldSum)

    //8
    val foldMax = fold(list, 0.0, {max,next -> if(max < next.price) max == next.price})


    //c)
    val kaeseFactory = productFactory("Käse" , 5)
    val teurerKaese = kaeseFactory(4.99)
    val billigerKaese = kaeseFactory (0.99)
    println(teurerKaese)
    println(billigerKaese)
}

//a)
fun <T,R> map (list : List<T> , f : (T)-> R) : List<R> = when(list) {
        is Nil -> List()
        is Node -> Node(f(list.head), map(list.tail,f))
}

fun <T> replaceIf (list : List<T> , f : (T)-> T , p : (T)-> Boolean ):List<T> = when(list){
    is Nil -> Nil as List<T>
    is Node -> if (p(list.head)) Node(f(list.head), replaceIf(list.tail,f,p))
    else Node(list.head, replaceIf(list.tail,f,p))
}

fun <T> filter ( list : List<T> , p : (T)-> Boolean ) : List<T> = when(list) {
    is Nil -> Nil as List<T>
    is Node -> if(p(list.head)) Node(list.head, filter(list.tail,p))
    else filter(list.tail,p)
}

fun <T> any ( list : List<T> , p : (T)-> Boolean ) : Boolean = when(list) {
    is Nil -> false
    is Node -> if (p(list.head)) true
    else any(list.tail, p)
}

fun <T> anyIteration (list: List<T>, p: (T) -> Boolean): Boolean {
    var tmp = list
    while (tmp is Node){
            if (p(tmp.head)) return true
            else tmp = tmp.tail
    }
    return false
}

fun <T> anyFold (list: List<T>, p: (T) -> Boolean): Boolean = fold(list, false, )


tailrec fun <T,R> fold( list : List <T> , accumulated : R , f : (R,T)->R ) : R = when(list) {
    is Nil -> accumulated
    is Node -> fold(list.tail, f(accumulated, list.head), f)
}

fun productFactory (productName: String, rating: Int): (Double) -> Product {
    return {price -> Product(productName, price, rating)}
}