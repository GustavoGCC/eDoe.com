package eDoe;

import java.io.Serializable;

public class Doacao implements Comparable<Doacao>, Serializable{
	String data;
	String descricaoItemDoado;
	
	public Doacao(String data,String descricaoItemDoado) {
		this.data = data;
		this.descricaoItemDoado = descricaoItemDoado;
	}

	public String getData() {
		return data;
	}

	public String getDescricaoItemDoado() {
		return descricaoItemDoado;
	}

	@Override
	public int compareTo(Doacao o) {
		String datas1[] = new String[3];
		String datas2[] = new String[3];
		
		datas1 = data.split("/");
		datas2 = o.getData().split("/");
		
		int dia1 = Integer.parseInt(datas1[0]); 
		int mes1 = Integer.parseInt(datas1[1]); 
		int ano1 = Integer.parseInt(datas1[2]); 
		
		int dia2 = Integer.parseInt(datas2[0]); 
		int mes2 = Integer.parseInt(datas2[1]); 
		int ano2 = Integer.parseInt(datas2[2]);
		
		if (ano1 < ano2) return -1;
		
		else if (ano1 > ano2) return 1;
		
		else if (mes1 < mes2) return -1;
		
		else if (mes1 > mes2) return 1;
		
		else if (dia1 < dia2) return -1;
		
		else if (dia1 > dia2) return 1;
		
		else return descricaoItemDoado.compareTo(o.getDescricaoItemDoado());
	}
	
	
}
