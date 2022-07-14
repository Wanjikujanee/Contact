package dev.jane.mycontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.jane.mycontact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact=Contact("jane","07123647565","jane@gmail.com","nakuru way","https://images.pexels.com/photos/935985/pexels-photo-935985.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact1=Contact("sha","07354665857","sha@gmail.com","korongo road","https://images.pexels.com/photos/1191503/pexels-photo-1191503.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2=Contact("rehema","0724343254","rehema@gmail.cim","uhuru way","https://images.pexels.com/photos/965324/pexels-photo-965324.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3=Contact("joan","07030937736","joan@gmail.com","nyayo way","https://images.pexels.com/photos/794062/pexels-photo-794062.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4=Contact("nyakwar","07342156537","nyakwar@gmail.com","highway","https://images.pexels.com/photos/718978/pexels-photo-718978.jpeg?auto=compress&cs=tinysrgb&w=400")

        var contactList= listOf(contact,contact1,contact2,contact3,contact4)
        var contactsAdapter=ContactsRvAdapter(contactList)
        binding.rvcontacts.layoutManager=LinearLayoutManager(this)
        binding.rvcontacts.adapter=contactsAdapter

    }

}