package database

import com.example.kmp_playzone.DataBase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val databaseModule = DI.Module("databaseModule") {
    bind<DbDriverFactory>() with singleton {
        DbDriverFactory(instance())
    }

    bind<DataBase>() with singleton {
        val driverFactory = instance<DbDriverFactory>()
        val driver = driverFactory.createDriver(DataBase.Schema, "kmp_playzone.db")
        DataBase(driver)
    }
}