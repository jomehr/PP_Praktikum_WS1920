package a2

class Product (var productName : String, var price : Double, var rating : Int)  {
    override fun toString() = "($productName, $price, $rating)"
}