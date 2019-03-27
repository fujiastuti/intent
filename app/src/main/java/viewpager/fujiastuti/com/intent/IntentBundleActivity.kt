package viewpager.fujiastuti.com.intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent_bundle.*

class IntentBundleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_bundle)

        val NAMAKU =intent.getStringExtra("NAMAKU")
        val ALAMAT =intent.getStringExtra("ALAMAT")
        val NPM =intent.getStringExtra("NPM")
        val JENIS_KELAMIN =intent.getStringExtra("JENIS_KELAMIN")
        val FOTO =intent.getStringExtra("FOTO")
        tvNamaku.text = NAMAKU
        tvAlamat.text = ALAMAT
        tvNPM.text = NPM
        tvJenis_Kelamin.text = JENIS_KELAMIN

    }
}
