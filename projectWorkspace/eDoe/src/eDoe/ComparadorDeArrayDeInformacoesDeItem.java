package eDoe;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * Comparador especifico que foi criado para ser usado no metodo listaItemNecessarios() do controlador,
 *   ele ordena baseado no primeiro valor de um array de string, considerando que esse e um numero,
 *   ordenando de forma crescente com base nesse elemento
 * @author Joao Victor Teodulo Wanderley
 *
 */
public class ComparadorDeArrayDeInformacoesDeItem implements Comparator<String[]> {
	/**
	 * Construtor que constroi a classe sem nenhum atributo
	 */
	public ComparadorDeArrayDeInformacoesDeItem() {
		
	}
	/**
	 * Ordena baseado no primeiro valor de um array de string, considerando que esse e um numero,
     *   ordenando de forma crescente com base nesse elemento
	 */
	@Override
	public int compare(String[] o1, String[] o2) {
		if (Integer.valueOf(o1[0]) > Integer.valueOf(o2[0])) {
			return 1;
		}else if (Integer.valueOf(o1[0]) < Integer.valueOf(o2[0])) {
			return -1;
		} else {
			return 0;
		}
	}

}
