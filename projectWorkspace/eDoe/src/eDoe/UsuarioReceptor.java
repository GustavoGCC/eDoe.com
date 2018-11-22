package eDoe;

import java.util.HashSet;
import java.util.Set;

public class UsuarioReceptor extends Usuario{
	private Set<ItemNecessario> itensNecessarios;
	
	public UsuarioReceptor(String id, String nome, String email, String celular, String classe){
		this.nome=nome;
		this.id=id;
		this.email=email;
		this.celular=celular;
		this.classe=classe;
		this.itensParaDoacao=new HashMap<>();
		status="receptor";
		itensNecessarios=new HashSet<>();
		
	}
	
}
