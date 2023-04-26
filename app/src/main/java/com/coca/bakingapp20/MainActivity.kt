package com.coca.bakingapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coca.bakingapp20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
   viewModel.myRecipe.observe(this, Observer { myRecipe->
       val adapter = ArrayAdapter(
           this,
           android.R.layout.simple_list_item_1,myRecipe
       )
       val listView: ListView = findViewById(R.id.list_view)
       listView.adapter = adapter
       listView.onItemClickListener =
           AdapterView.OnItemClickListener { adapterView: AdapterView<*>, view: View, position:Int, l: Long -> DetailDisplay(position)
           }
   })
        viewModel.getRecipes()
    }

    private fun DetailDisplay(position: Int) {
        val intent = Intent(this, DetailDisplayActivity::class.java)
        intent.putExtra(DetailDisplayActivity.EXTRA_POSITION, position)
        intent.putExtra(DetailDisplayActivity.EXTRA_POSITION, position)
        startActivity(intent)

    }
}

private operator fun Int.Companion.get(position: Int) {

}

private operator fun String.Companion.get(position: Int) {

}
