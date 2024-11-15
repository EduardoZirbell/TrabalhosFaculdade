package exercicios.lista02;

import java.util.Objects;

public class Carro {

	private String placa;
	private String nomeProprietario;
	
	public Carro(String placa, String nomeProprietario) {
		super();
		this.placa = placa;
		this.nomeProprietario = nomeProprietario;
	}
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	
	public String getPlaca() {
		return placa;
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
