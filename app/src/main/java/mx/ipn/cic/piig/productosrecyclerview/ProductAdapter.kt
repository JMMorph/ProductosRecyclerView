package mx.ipn.cic.piig.productosrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter (private val productos: Map<String,Producto>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

//class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNombre: TextView
        val textViewPrecio: TextView
        val textViewExistencia: TextView
        val textViewMarca: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textViewMarca = view.findViewById(R.id.textViewMarca)
            textViewNombre = view.findViewById(R.id.textViewNombre)
            textViewPrecio = view.findViewById(R.id.textViewPrecio)
            textViewExistencia = view.findViewById(R.id.textViewExistencia)


        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        var temp = productos.keys.toTypedArray()
        temp.sort()
        viewHolder.textViewMarca.text = productos[temp[position]]!!.marca
        viewHolder.textViewNombre.text = productos[temp[position]]!!.nombre
        viewHolder.textViewPrecio.text = productos[temp[position]]!!.precio
        viewHolder.textViewExistencia.text = productos[temp[position]]!!.existencia
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = productos.size

}

/*
class ProductAdapter (private val productos: ArrayList<Producto>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

//class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNombre: TextView
        val textViewPrecio: TextView
        val textViewExistencia: TextView
        val textViewMarca: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textViewMarca = view.findViewById(R.id.textViewMarca)
            textViewNombre = view.findViewById(R.id.textViewNombre)
            textViewPrecio = view.findViewById(R.id.textViewPrecio)
            textViewExistencia = view.findViewById(R.id.textViewExistencia)


        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textViewMarca.text = productos[position].marca
        viewHolder.textViewNombre.text = productos[position].nombre
        viewHolder.textViewPrecio.text = productos[position].precio
        viewHolder.textViewExistencia.text = productos[position].existencia
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = productos.size

}*/