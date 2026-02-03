import com.example.marsphotos.marsphotos.model.MarsPhoto
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL =
    "https://6942ad5169b12460f3125e49.mockapi.io/api/v1/"

private val retrofit1 = Retrofit.Builder()

private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())

private val retrofit = Retrofit.Builder()
    //.addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("personas")
    suspend fun getPhotos(): List<MarsPhoto>//String

    @POST("personas")
    suspend fun setPhoto(photo: MarsPhoto): MarsPhoto
}

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}