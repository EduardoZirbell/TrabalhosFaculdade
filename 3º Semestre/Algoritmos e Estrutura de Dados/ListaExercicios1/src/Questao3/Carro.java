package Questao3;

import java.util.Objects;

public class Carro {
	private String placa;
	private String nomeProprietario;
	
	public Carro(String placa, String nome) {
		this.placa = placa;
		this.setNomeProprietario(nome);
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	@Override
	public String toString() {
		return placa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(placa, other.placa);
	}
}
