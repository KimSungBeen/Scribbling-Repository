package org.gwnu.tutorial.dagger2

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BurgerModule {

    @Provides
    @Named(value = "beef")
    fun provideBeefBurger(bun: WheatBun, patty: BeefPatty) = Burger(bun = bun, patty = patty)

    @Provides
    @Named(value = "fork")
    fun provideForkBurger(bun: WheatBun, patty: ForkPatty) = Burger(bun = bun, patty = patty)

    @Provides
    fun provideBun() = WheatBun()

    @Provides
    fun provideBeefPatty() = BeefPatty()

    @Provides
    fun provideForkPatty() = ForkPatty()
}