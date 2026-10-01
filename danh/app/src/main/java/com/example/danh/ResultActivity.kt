package com.example.danh

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Ánh xạ View
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)

        val btnBack = findViewById<Button>(R.id.btnBack)

        // ==============================
        // LẤY EXTRA / BUNDLE TỪ INTENT
        // ==============================
        val bundle = intent.extras

        if (bundle != null) {

            // Lấy dữ liệu từ Bundle
            val name = bundle.getString("FULL_NAME", "")
            val age = bundle.getInt("AGE", 0)
            val email = bundle.getString("EMAIL", "")

            // Hiển thị dữ liệu
            tvName.text = "Họ tên: $name"
            tvAge.text = "Tuổi: $age"
            tvEmail.text = "Email: $email"
        }

        // ==============================
        // BACK VỀ MÀN HÌNH 1
        // ==============================
        btnBack.setOnClickListener {

            finish()

        }
    }
}