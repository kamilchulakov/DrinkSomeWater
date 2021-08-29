package com.github.ulyanovskk.drinksomewater2

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.github.ulyanovskk.drinksomewater2.model.AppDatabase
import com.github.ulyanovskk.drinksomewater2.model.Note
import com.github.ulyanovskk.drinksomewater2.model.Repository
import com.github.ulyanovskk.drinksomewater2.utils.getCurrentData
import com.github.ulyanovskk.drinksomewater2.utils.getCurrentTime
import com.github.ulyanovskk.drinksomewater2.utils.ioThread
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
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "note"
        )
            .build()
        ioThread {
            //db.noteDao().insert(Note(1, getYesterdayData(), getCurrentTime(), 2000, 2000))
            db.noteDao().insert(Note(2, getCurrentData(), getCurrentTime(), 1000, 2000))
        }
        return db
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