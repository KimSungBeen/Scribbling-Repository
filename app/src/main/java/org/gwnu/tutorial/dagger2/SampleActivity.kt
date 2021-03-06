package org.gwnu.tutorial.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import org.gwnu.tutorial.R
import javax.inject.Inject
import javax.inject.Named

class SampleActivity : AppCompatActivity() {

    @Inject
    @Named(value = "beef")
    lateinit var burger: Burger

    @Inject
    @Named(value = "fork")
    lateinit var burger2: Burger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sample)

//        DaggerBurgerComponent.builder()
//                .burgerModule(BurgerModule())
//                .build()
//                .inject(this)

        DaggerBurgerComponent.create().inject(this)

        burger.info()
        burger2.info()

        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}