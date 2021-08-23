package com.android.weatherforecastdemo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.weatherforecastdemo.network.WeatherApis
import com.android.weatherforecastdemo.objects.StateDoItem
import com.android.weatherforecastdemo.usecases.StateListUseCase
import com.android.weatherforecastdemo.viewModels.StateListViewModel
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.system.measureTimeMillis


@ExperimentalCoroutinesApi
class StatesViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    lateinit var stateListUseCase: StateListUseCase
    lateinit var services: WeatherApis

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/dilip786/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
        services = retrofit.create(WeatherApis::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun testStatesListSuccessPath() {
        runBlocking {
            Mockito.doReturn(getDummyData())
                .`when`(stateListUseCase)
                .getAction()
            val viewModel = StateListViewModel(stateListUseCase)
            viewModel.getStatesList()
            Assert.assertEquals(1, viewModel.handleStatesList.value?.size)
        }
    }

    @Test
    fun testStatesApiTest() {
        var time: Long?
        runBlocking {
            time = measureTimeMillis {
                val list = services.getStates()
                println("News Count: ${list?.size}")
                Assert.assertEquals(true, list?.size ?: 0 > 0)
            }
        }
        println("Time taken: $time")
    }

    private fun getDummyData(): MutableList<StateDoItem> {
        return mutableListOf(
            StateDoItem(
                lat = "121",
                lon = "Paytm is launching its own digital wallet to improve payments for its users",
                state = "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash.",
                name = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg"
            )
        )
    }
}