package examanPoo;

import java.time.LocalDate;

public class Blog {
	private String titre;
	private Publiable[] LBillets;
	private  int nbBillets;
	public Blog(String titre,int capacite) {
		this.titre = titre;
		LBillets=new Publiable[capacite];
		nbBillets=0;
	}
	public void post(Publiable billet) {
		try {
			if(nbBillets<LBillets.length) {
				if(billet instanceof BilletTaggable) {
					if(	(BilletTaggable)billet 	instanceof Video) {
						if(((Video) ((BilletTaggable)billet)).getUrl().startsWith("HTTPS")==false){
							throw new Exception();
						}
						else {
							LBillets[nbBillets++]=billet;
						}
					}
				}
			}
		}
		catch(Exception  e) {
			System.out.println("InvalidURLException ");
		}
	}
	public int getNombreBilletsTaggables() {
		int nb=0;
		for(int i=0;i<nbBillets;i++) {
			if(LBillets[i] instanceof BilletTaggable) {
				nb++;
			}
		}
		return nb;
		 
	}
	public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
		 Publiable pub[] = null;
		 int nbP=0;
		 for(int i=0;i<nbBillets;i++) {
			 if(LBillets[i].getAuteur().equals(auteur)) {
				 pub[nbP++]=LBillets[i];
			 }
		 }
		 
		 return pub;
	}
	public Publiable getPlusRécentBillet() {
		Publiable PubR=LBillets[0];
		LocalDate Date=PubR.getDatePublication();
		for(int i=0;i<nbBillets;i++) {
			 if(LBillets[i].getDatePublication().isAfter(Date)) {
				 PubR=LBillets[i];
			 }
		 }
		
		return PubR;
	}
	public Publiable[] RechercheBilletsParContenu(String[] mots) {
		 Publiable pub[] = null;
		 int nbP=0;
		 for(int i=0;i<nbBillets;i++) {
			 if(LBillets[i] instanceof Message) {
				 if(((Message)LBillets[i]).getContenu().indexOf(mots[i])!=-1) {
					 pub[nbP++]=LBillets[i];
				 }
				 
			 }
		 }
		 
		 return pub;
	}
	
}

