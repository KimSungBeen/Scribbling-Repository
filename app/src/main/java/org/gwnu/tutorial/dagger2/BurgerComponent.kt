package org.gwnu.tutorial.dagger2

import dagger.Component

@Component(modules = [BurgerModule::class])
interface BurgerComponent {

    fun inject(activity: SampleActivity)
}