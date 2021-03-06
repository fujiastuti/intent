package viewpager.fujiastuti.com.intent

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment.getExternalStorageDirectory
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_implisit_intent.*
import viewpager.fujiastuti.com.intent.R.id.btnCapture
import java.io.File

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class ImplisitIntentActivity : AppCompatActivity() {

    fun buka(view: View) {
        val url = "https://google.com"
        val bukabrowser = Intent(Intent.ACTION_VIEW)
        bukabrowser.data = Uri.parse(url)
        startActivity(bukabrowser)
    }


    val REQUEST_IMAGE_CAPTURE = 0
    private val TAKE_PICTURE = 1
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implisit_intent)
        btnCapture.setOnClickListener {
           dispatchTakePictureIntent()
        }


    }

    fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }

        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                val imageBitmap = data?.extras?.get("data") as Bitmap
                iv.setImageBitmap(imageBitmap)
            }
        }
    }

