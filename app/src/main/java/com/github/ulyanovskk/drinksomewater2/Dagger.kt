package com.github.ulyanovskk.drinksomewater2

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.github.ulyanovskk.drinksomewater2.model.AppDatabase
import com.github.ulyanovskk.drinksomewater2.model.Repository
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [RepoModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun context(context: Context): Builder
    }
    fun inject(repository: Repository)
}

@Module
class RepoModule {
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}

class MyApp: Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
         appComponent = DaggerAppComponent.builder()
             .context(applicationContext)
             .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MyApp -> appComponent
        else -> {
            applicationContext.appComponent
        }
    }