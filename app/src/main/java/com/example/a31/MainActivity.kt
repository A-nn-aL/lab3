package com.example.a31

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a31.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.button.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
                Toast.makeText(this, "Error sending a message", Toast.LENGTH_LONG).show()
            }

        }
        binding.button2.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "Важное сообщение!")
            i.putExtra(Intent.EXTRA_TEXT, "Привет, как дела?")
            startActivity(i)
        }

//        binding.button2.setOnClickListener {
////            //val imageBitmap = data?.extras?.get("data") as Bitmap
////            val i = Intent(Intent.ACTION_SEND)
////            i.type = "text/plain"
////            i.putExtra(Intent.EXTRA_SUBJECT, "Litvinenko Hanna, NAI-196, lab3")
////            i.putExtra(Intent.EXTRA_TEXT, "jyfuytd")
////            //i.putExtra(Intent.ACTION_ATTACH_DATA, imageBitmap)
////            try {
////                startActivity(i)
////            } catch (e: ActivityNotFoundException) {
////                Toast.makeText(this, "Error sending a message", Toast.LENGTH_LONG).show()
////            }
////        }
//            val i = Intent(Intent.ACTION_SENDTO)
//            i.type = "text/plain"
//
//            startActivity(i)
//
//        }
    }
        public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            val binding = ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)

            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                val imageBitmap = data?.extras?.get("data") as Bitmap

                binding.imageView.setImageBitmap(imageBitmap)
            }


        }
    }
