import retrofit2.Call;
import retrofit2.http.GET;

public interface Controller {
    @GET("/random_joke")
    public Call<POJO> getJoke();
}
