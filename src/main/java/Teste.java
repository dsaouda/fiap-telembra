import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Teste {

	public static void main(String[] args) throws IOException {
		
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://api.totalvoice.com.br")
			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

		TTSService service = retrofit.create(TTSService.class);
		
		TTS tts = new TTS();
		tts.setMensagem("Ol� Heider Lopes, estou ligando para lembrar que o trabalho do Diego deve ser 10. N�o ser� aceito nota inferior. Brincadeira. Falando s�rio, esse � o projeto, um sistema de lembrete via telefone fixo ou celular.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		tts.setNumero_destino("11995478336");
		//tts.setNumero_destino("11973644683");
		Response<Object> execute = service.send(tts).execute();
		System.out.println(execute);		
	}
}
