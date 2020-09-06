package org.gwnu.tutorial.room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_room_tuto.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.gwnu.tutorial.R
import org.gwnu.tutorial.activity.DefaultActivity
import org.gwnu.tutorial.databinding.ActivityRoomTutoBinding

class RoomTuto : DefaultActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_tuto)
//        val binding = DataBindingUtil.setContentView<ActivityRoomTutoBinding>(this, R.layout.activity_room_tuto)
//        binding.lifecycleOwner = this

        viewModel.getAll().observe(this, Observer { todos ->
            room_result_text.text = todos.toString()
        })


//        binding.viewModel = viewModel

        room_add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Todo(room_edit.text.toString()))
            }
        }

    }
}