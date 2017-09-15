import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TTSService {
	
	
    //@GET("/tasks")
    //Call<List<Task>> getTasks();
	
	@Headers("Access-Token: fdf1d9f7a7fcdc2168eb1ad39fad88ff")
	@POST("/tts")
	Call<Object> send(@Body TTS tts);
	
}
