import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://official-joke-api.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Controller controller = retrofit.create(Controller.class);
                try {
                    Response<POJO> response = controller.getJoke().execute();
                    System.out.println(response.body().getSetup() + " " + response.body().getPunchline());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t.start();
    }

}
