package dev.jane.mycontact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import dev.jane.mycontact.databinding.ActivityViewContactBinding


class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
        val extras=intent.extras
        var name=extras?.getString("NAME","")
        var phone=extras?.getString("PHONE","")
        var email=extras?.getString("EMAIL","")
        var address=extras?.getString("ADDRESS","")
        var image=binding.imgView

        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,phone,Toast.LENGTH_LONG).show()
        Toast.makeText(this,email,Toast.LENGTH_LONG).show()
        Toast.makeText(this,address,Toast.LENGTH_LONG).show()


        binding.tvname.text=name
        binding.tvnumber.text=phone
        binding.tvaddress.text=address
        binding.tvemail.text=email

        Picasso.get()
            .load(intent.getStringExtra("IMAGE",)).into(image)













    }




}