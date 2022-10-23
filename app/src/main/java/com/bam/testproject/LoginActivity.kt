package com.bam.testproject

import android.Manifest
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var message: EditText
    lateinit var hour: EditText
    lateinit var min: EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val contact = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            var adress: Uri? = it.data?.data
            var proj: Array<String> = arrayOf(CommonDataKinds.Phone.DISPLAY_NAME)
            var cursor: Cursor? = contentResolver.query(adress!!, proj, null,
                null, null)

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(CommonDataKinds.Phone.DISPLAY_NAME)
                    val name = cursor.getString(index)
                    message.setText(name)
                }
            }
        }


        val permission = registerForActivityResult(RequestPermission()) {
            if (it) {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = CommonDataKinds.Phone.CONTENT_TYPE
                contact.launch(intent)

            } else {
                Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show()
            }
        }



        btn.setOnClickListener {
            permission.launch(Manifest.permission.READ_CONTACTS)
        }

    }


    private fun initViews() {
        message = findViewById(R.id.message_text_view)
        hour = findViewById(R.id.hour_text_view)
        min = findViewById(R.id.min_text_view)
        btn = findViewById(R.id.send_btn)
    }
}

