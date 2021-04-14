package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDAO;


public class Model {
	
	private List<String> corretti = new ArrayList <String>(); 
	private List<String> errati = new ArrayList <String>();
	
	private DizionarioDAO dizionario;
	
	
	public List<String> getCorretti() {
		return corretti;
	}

	public List<String> getErrati() {
		return errati;
	}

	public DizionarioDAO getDizionario() {
		return dizionario;
	}

	public Model() {
		this.dizionario = new DizionarioDAO();
	}
		
	public List<String> anagrammi(String parola){
		
		this.corretti.removeAll(corretti);
		this.errati.removeAll(errati);
		
		List<String> risultato = new ArrayList<>();
		recursive("",parola,0,risultato);
		return risultato;
	}
	
	private void recursive(String parziale, String lettere, int livello, List<String> risultato) {
		
		if(lettere.length()==0) {		
			
			if(dizionario.parolaPresente(parziale)==true){
				corretti.add(parziale);
			}else {
				errati.add(parziale);
			}
		}else{
			for(int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0,pos)+lettere.substring(pos+1);
						
				
				//if(this.dizionario.paroleSimili(nuovaParziale)>0) {			
					recursive(nuovaParziale,nuovaLettere,livello++,risultato);
				//}else {
					//break;
				//}
			}
		}
	}
}
