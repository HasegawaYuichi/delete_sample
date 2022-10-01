package com.example.delete_sample
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.delete_sample.databinding.ActivityMainBinding
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {

    //View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener(){
            //動画ファイルの保存先
            val path = Paths.get("/storage/emulated/0/Movies/sample/sample.mp4")

            try {
                Files.deleteIfExists(path)
            } catch (e : IOException) {
                e.printStackTrace()
            }

            //ファイルが存在しているかの確認
            if (Files.exists(path)) {
                //デバッグ実行でここ通っているので、パスは間違っていない？
                println("存在します")
            }

            if (Files.notExists(path)) {
                println("存在しません")
            }
        }
    }
}