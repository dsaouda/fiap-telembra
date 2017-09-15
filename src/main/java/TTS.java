public class TTS {

	private String numero_destino;
	private String mensagem;
	private String velocidade = "0";
	private boolean resposta_usuario = false;
	private String tipo_voz = "br-Vitoria";
	private String bina = "11995478336";
	public String getNumero_destino() {
		return numero_destino;
	}
	public void setNumero_destino(String numero_destino) {
		this.numero_destino = numero_destino;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}
	public boolean isResposta_usuario() {
		return resposta_usuario;
	}
	public void setResposta_usuario(boolean resposta_usuario) {
		this.resposta_usuario = resposta_usuario;
	}
	public String getTipo_voz() {
		return tipo_voz;
	}
	public void setTipo_voz(String tipo_voz) {
		this.tipo_voz = tipo_voz;
	}
	public String getBina() {
		return bina;
	}
	public void setBina(String bina) {
		this.bina = bina;
	}	
}
