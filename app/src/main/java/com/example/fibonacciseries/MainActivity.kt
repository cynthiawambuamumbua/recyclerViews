
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fibonacciseries.R.*

private fun <E> List<E>.size(): E {


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(id.rvName)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val numbers = getFibonacciNumbers(100)
        val adapter = Rv_Adapter(numbers)
        recyclerView.adapter = adapter
    }

    private fun getFibonacciNumbers(n: Int): List<Int> {
        val fibonacciNumbers = mutableListOf<Long>(0, 1)
        while (fibonacciNumbers.size < n) {
            val nextNumber = fibonacciNumbers[fibonacciNumbers.size - 1] + fibonacciNumbers[fibonacciNumbers.size - 2]
            fibonacciNumbers.add(nextNumber)
        }
        return getFibonacciNumbers(n)
    }
    class Rv_Adapter(private val fibonacciNumbers: List<Int>):
            RecyclerView.Adapter<Rv_Adapter.ViewHolder>() {
        inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            @SuppressLint("ResourceType")
            val fibonacciNumbers: TextView = itemView.findViewById(layout.fibonacci_series_numbers)


        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.fibonacciNumbers.text = fibonacciNumbers[position].toString()
        }


