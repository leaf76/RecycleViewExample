package com.leaf76.recycleviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.leaf76.recycleviewexample.Adapters.ExampleAdapter
import com.leaf76.recycleviewexample.Data.ExampleItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(200)

        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<ExampleItem>{
        val list = arrayListOf<ExampleItem>()

        for (i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.ic_brightness_5
                1 -> R.drawable.ic_attach_money
                else -> R.drawable.ic_android
            }

            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }

}
