package org.gwnu.tutorial.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        DaggerBurgerComponent.builder()
                .burgerModule(BurgerModule())
                .build()
                .inject(this)

        burger.info()
        burger2.info()
    }

}