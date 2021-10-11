package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var inputNis:EditText
    private lateinit var inputNama:EditText
    private lateinit var jkLakiLaki:RadioButton
    private lateinit var jkPerempuan:RadioButton
    private lateinit var btnTambah: Button
    private lateinit var recyclerView:RecyclerView
    private lateinit var recyclerAdapter:RecyclerView.Adapter<*>
    private lateinit var viewManager:RecyclerView.LayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNis=findViewById(R.id.txtInputNIS)
        inputNama=findViewById(R.id.txtInputNama)
        jkLakiLaki=findViewById(R.id.rblakilaki)
        jkPerempuan=findViewById(R.id.rbperempuan)
        btnTambah=findViewById(R.id.btnTambah)
        recyclerView=findViewById(R.id.ListData)
        //membuat variabel kosong tipe array MutableList untuk simpan data array
        //data array disimpan didata class SiswaData
        val data= mutableListOf<SiswaData>()
        viewManager=LinearLayoutManager(this)
        recyclerAdapter=SiswaAdapter(data)
        recyclerView.adapter=recyclerAdapter
        recyclerView.layoutManager=viewManager
        //setOnclickListener untuk tombol tambah data
        btnTambah.setOnClickListener {
            //1.mebuat variabel penyimpanan data
            val nis=inputNis.text.toString()
            val nama=inputNama.text.toString()
            var jk=""
            if(jkLakiLaki.isChecked){
                jk="Laki-Laki"
            }else {
                jk = "Perempuan"
            }
            //simpan data ke array mutableList
            val dataSiswa=SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }
}