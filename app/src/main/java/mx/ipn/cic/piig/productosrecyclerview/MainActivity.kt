package mx.ipn.cic.piig.productosrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*----------------------------------- MANUALES ----------------------------------*/

        /*
        val materias: Array<String> = arrayOf<String>("Programacion 1", "Programacion 2", "Programacion 3", "Analisis Vectorial","Álgebra Lineal","Cálculo Diferencial",
            "Cálculo Vectorial","Física1","Variable Compleja","Teoría Electromagnética","Electrónica Analógica I","Electrónica Digital")
        val recyclerView: RecyclerView = this.findViewById(R.id.recyclerViewProductos)
        val adapter = CustomAdapter(materias)
        recyclerView.adapter = adapter
        */


        /*----------------------------------- FIREBASE ----------------------------------*/


        val productos = mutableMapOf<String, Producto>()
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val referenciaBD : DatabaseReference = database.getReference("app_listview/productos")
        val recyclerView: RecyclerView = this.findViewById(R.id.recyclerViewProductos)
        val adapter = ProductAdapter(productos)
        recyclerView.adapter = adapter

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager



        referenciaBD.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(databaseError: DatabaseError) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildChanged(dataSnapshot: DataSnapshot, previousName: String?) {
                Log.d("onChildChanged", dataSnapshot.toString())
                Log.d("onChildChanged2", previousName!!)
                var producto = dataSnapshot.getValue(Producto::class.java)!!
                productos.remove(dataSnapshot.key!!)
                productos[dataSnapshot.key!!] = producto
                adapter.notifyDataSetChanged()
            }
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                Log.d("onChildRemoved", dataSnapshot.toString())
                productos.remove(dataSnapshot.key)
                adapter.notifyDataSetChanged()

            }

            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                Log.d("onChildAdded", dataSnapshot.toString())
                Log.d("onChildAdded2", dataSnapshot.key.toString())
                var producto = dataSnapshot.getValue(Producto::class.java)!!
                productos[dataSnapshot.key!!] = producto
                adapter.notifyDataSetChanged()
            }
        })



    }
}