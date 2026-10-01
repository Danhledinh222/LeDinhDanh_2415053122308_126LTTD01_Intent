package com.example.danh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ View
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)

        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {

            // Lấy dữ liệu người dùng nhập
            val name = edtName.text.toString().trim()
            val ageText = edtAge.text.toString().trim()
            val email = edtEmail.text.toString().trim()

            // Kiểm tra dữ liệu
            if (name.isEmpty() || ageText.isEmpty() || email.isEmpty()) {

                Toast.makeText(
                    this,
                    "Vui lòng nhập đầy đủ thông tin",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()

            if (age == null || age <= 0) {

                Toast.makeText(
                    this,
                    "Tuổi không hợp lệ",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // =========================
            // TẠO INTENT
            // =========================
            val intent = Intent(this, ResultActivity::class.java)

            // =========================
            // TẠO BUNDLE
            // =========================
            val bundle = Bundle()

            // Thêm dữ liệu vào Bundle
            bundle.putString("FULL_NAME", name)
            bundle.putInt("AGE", age)
            bundle.putString("EMAIL", email)

            // =========================
            // ĐƯA BUNDLE VÀO EXTRA
            // =========================
            intent.putExtras(bundle)

            // Chuyển sang màn hình 2
            startActivity(intent)
        }
    }
}