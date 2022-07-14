package dev.jane.mycontact

import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.jane.mycontact.databinding.ActivityMainBinding
import dev.jane.mycontact.databinding.ContactListItemBinding
import org.w3c.dom.Text

class ContactsRvAdapter(var contactList:List<Contact>):
    RecyclerView.Adapter<contactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        var binding = ContactListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return contactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        val context = holder.itemView.context
        var currentContact = contactList.get(position)
        val contactBinding = holder.binding
        contactBinding.tvName.text = currentContact.name
        contactBinding.tvNumber.text = currentContact.phone
        contactBinding.tvAddress.text = currentContact.address
        contactBinding.tvEmail.text = currentContact.email

        Picasso.get()
            .load(currentContact.image)
            .resize(300,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(contactBinding.imgImage);

        holder.binding.imgImage.setOnClickListener {
            val intent = Intent(context, ViewContactActivity::class.java)
            intent.putExtra("NAME", currentContact.name)
            intent.putExtra("PHONE_NUMBER", currentContact.phone)
            intent.putExtra("Address",currentContact.address)
            intent.putExtra("Email",currentContact.email)
            context.startActivity(intent)

        }
        holder.binding.imgImage.setOnClickListener {
            Toast
                .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                .show()


        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
class contactViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root){

}