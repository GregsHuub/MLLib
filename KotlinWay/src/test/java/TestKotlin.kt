import com.library.entityKotli.Book
import com.library.enums.Data
import com.library.implementation.Implementation
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.omg.CORBA.Object
import java.util.concurrent.ConcurrentHashMap

val impl = Implementation()
//val dataBase = impl.setUpDatabase()
val MAP = impl.setUpDatabase()
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestKotlin() : Runnable {

//    lateinit var map: ConcurrentHashMap<Long, Book>
    override fun run() {
        println("Current Thread: ${Thread.currentThread()}")
    }
    @BeforeAll
    fun setUp() {
        Thread(Runnable {
            println("BeforeAllThread: " + Thread.currentThread())
//            MAP
            run()
        }).start()
    }
    @Test
    fun searchChecker() {
//        impl.printAll()
        assertEquals(MAP.getValue(1).author, impl.findBook("Angels","Brown", year = 2013))
//        assertEquals(MAP.getValue(1).author,impl.findBook("angels","brown",2013) )
//        assertEquals(MAP.getValue(1).author,impl.findBook("deamons","dan",2013) )
//        assertEquals(MAP.getValue(1).author,impl.findBook("gels","br",2013) )
    }
    @Test
    fun enumChecker() {
        Thread(Runnable {
            println("Thread enumCkecherpart1: ${Thread.currentThread()}")
            assertEquals(MAP.getValue(1).author, Data.DanBrown.ANGELS.author)
            assertEquals(MAP.getValue(2).title, Data.DanBrown.INFERNO.title)
            assertEquals(MAP.getValue(2).author, Data.DanBrown.INFERNO.author)
        }).start()
    }

    @Test
    fun enumCheckerPart2() {
        Thread(Runnable {
            println("Thread enumCheckerPart2: ${Thread.currentThread()}")
            assertEquals(MAP.getValue(3).year, Data.DanBrown.LOSTSYMBOLS.year)
            assertEquals(MAP.getValue(3).author, Data.DanBrown.LOSTSYMBOLS.author)
        }).start()
    }
    @Test
    fun enumCheckerPart3() {
            println("Thread enumCheckerPart3: ${Thread.currentThread()}")
            assertEquals(MAP.getValue(4).author, Data.DanBrown.ORIGIN.author)

    }

    @AfterAll
    fun cleanGarbageCollector() {
        run()
        System.gc()
    }


}