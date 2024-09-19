package com.qtonz.adapter.roomrecycler

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.adapter.R
import com.qtonz.adapter.databinding.ActivityMainRoomrecyclerBinding
import com.qtonz.adapter.roomrecycler.adapter.UserAdapter
import com.qtonz.adapter.roomrecycler.database.User
import com.qtonz.adapter.roomrecycler.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainRoomrecyclerBinding by lazy {
        ActivityMainRoomrecyclerBinding.inflate(layoutInflater)
    }

    private lateinit var userDatabase: UserDatabase
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList: MutableList<User>
    private var isEditMode = false
    private var currentUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        userDatabase = UserDatabase.getDatabase(this)
        userList = mutableListOf()

        userAdapter = UserAdapter(userList, ::onEditClicked, ::onDeleteClicked)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }

        loadExistingUsers()

        addListener()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadExistingUsers() {
        lifecycleScope.launch {
            val usersFromDb = withContext(Dispatchers.IO) {
                userDatabase.userDao().getAllUsers()
            }
            userList.addAll(usersFromDb)
            userAdapter.notifyDataSetChanged()
        }
    }

    private fun addListener() {
        binding.btnSave.setOnClickListener {
            val number = binding.edNumber.text.toString().trim()
            val firstName = binding.edFirst.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            if (number.isNotEmpty()) {
                if (firstName.isEmpty()) {
                    Toast.makeText(
                        this, getString(R.string.please_enter_first_name), Toast.LENGTH_LONG
                    ).show()
                } else if (email.isEmpty()) {
                    Toast.makeText(this, getString(R.string.please_enter_email), Toast.LENGTH_LONG)
                        .show()
                } else {
                    if (isEditMode) {
                        updateData(number, firstName, email)
                    } else {
                        saveData(number, firstName, email)
                    }
                }
            } else {
                Toast.makeText(this, getString(R.string.please_enter_number), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun saveData(number: String, firstName: String, email: String) {
        val user = User(number = number, firstName = firstName, email = email)

        lifecycleScope.launch {
            val count = withContext(Dispatchers.IO) {
                userDatabase.userDao().isNumberExists(number)
            }
            if (count > 0) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.this_number_already_exists),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                withContext(Dispatchers.IO) {
                    userDatabase.userDao().insertUser(user)
                }

                userList.add(user)
                userAdapter.notifyItemInserted(userList.size - 1)

                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.data_saved_successfully),
                    Toast.LENGTH_LONG
                ).show()
                clearFields()
            }
        }
    }

    private fun updateData(number: String, firstName: String, email: String) {
        currentUser?.let {
            it.number = number
            it.firstName = firstName
            it.email = email

            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    userDatabase.userDao().updateUser(it)
                }

                val index = userList.indexOf(it)
                userList[index] = it
                userAdapter.notifyItemChanged(index)

                Toast.makeText(this@MainActivity,
                    getString(R.string.user_updated_successfully), Toast.LENGTH_LONG)
                    .show()
                clearFields()
            }
        }
    }

    private fun clearFields() {
        binding.edNumber.text!!.clear()
        binding.edFirst.text!!.clear()
        binding.edEmail.text!!.clear()
        isEditMode = false
        currentUser = null
    }

    private fun onEditClicked(user: User) {
        binding.edNumber.setText(user.number)
        binding.edFirst.setText(user.firstName)
        binding.edEmail.setText(user.email)

        isEditMode = true
        currentUser = user
    }

    private fun onDeleteClicked(user: User) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                userDatabase.userDao().deleteUser(user)
            }
            val position = userList.indexOf(user)
            if (position != -1) {
                userList.removeAt(position)
                userAdapter.notifyItemRemoved(position)
            }
        }
    }
}