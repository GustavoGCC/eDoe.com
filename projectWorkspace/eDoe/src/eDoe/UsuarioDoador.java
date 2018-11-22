package eDoe;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDoador extends Usuario {
	
	public UsuarioDoador(String id, String nome, String email, String celular, String classe){
		this.nome=nome;
		this.id=id;
		this.email=email;
		this.celular=celular;
		this.classe=classe;
		status="doador";
		itensParaDoacao=new HashMap<>();
		
	}


	
	
}