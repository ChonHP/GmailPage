package com.example.gmailpage

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import kotlin.random.Random

class MyListAdapter(var mCtx: Context, var resource:Int, var items:List<Email>)
    : ArrayAdapter<Email>( mCtx , resource , items ){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageBase = view.findViewById<TextView>(R.id.imageBase)
        val sender = view.findViewById<TextView>(R.id.txtSender)
        val timeSend = view.findViewById<TextView>(R.id.txtTimeSend)
        val subject = view.findViewById<TextView>(R.id.txtSubject)
        val content = view.findViewById<TextView>(R.id.txtContent)


        var email : Email = items[position]

        imageBase.text = email.sender.get(0).toString()
        imageBase.setBackgroundColor(email.color)
        sender.text = email.sender
        timeSend.text = email.timeSend
        subject.text = email.subject
        content.text = email.content

        return view
    }

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = "Inbox"
        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.baseline_menu_24)

        val listView = findViewById<ListView>(R.id.lvGmail)
        var list = mutableListOf<Email>()
        val rnd: Random = Random
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 1",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 2",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 3",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 4",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 5",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 6",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 7",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 8",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )
        list.add(Email(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            "Sender 9",
            "Lorem",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
        )


        listView.adapter = MyListAdapter(this, R.layout.row, list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater;
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}