package mx.ipn.cic.piig.productosrecyclerview

class Producto(var nombre: String= "",
               var marca: String = "",
               var precio: String = "",
               var existencia: String = ""){

    companion object{
    val data = arrayListOf(
        Producto("p1","Kingdom","100","SI"),
        Producto("p2","Kingdom","100","SI"))
}

}