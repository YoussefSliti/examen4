package examanPoo;

import java.time.LocalDate;
import java.util.Arrays;

public class BilletTaggable  extends Buillet implements Taggable{
	protected String[] LTags;
	protected int nbTags;
	
	public BilletTaggable(LocalDate datePub, String auteur,int capacite) {
		super(datePub, auteur);
		// TODO Auto-generated constructor stub
		 LTags=new String[capacite];
		 nbTags=0;
	}

	
	
	

	@Override
	public void ajoutTag(String tag) {
		if(rechercheTag(tag)==-1 && nbTags<LTags.length) {
			LTags[nbTags++]=tag;
		}
		else {
			System.out.println("deja existe");
		}
		
	}

	@Override
	public void supprimeTag(String tag) {
		int nb=0;
		// TODO Auto-generated method stub
		for(int i=0;i<nbTags-1;i++) {
			if(rechercheTag(LTags[i])!=-1 && nb!=1) {
				LTags[i]=LTags[i+1];
				nb++;
			}
			else if(rechercheTag(LTags[nbTags])==-1) {
				LTags[i]=LTags[i+1];
			}
			else {
				LTags[i]=LTags[i+1];
			}
			
		}
		
	}

	@Override
	public int nombreTags() {
		// TODO Auto-generated method stub
		return nbTags;
	}

	@Override
	public int rechercheTag(String tag) {
		int pos=-1;
		for(int i=0;i<nbTags;i++) {
			if(LTags[i].equals(tag)) {
				pos=i;
			}
		}
		
		return pos;
	}





	@Override
	public String toString() {
		return "BilletTaggable [LTags=" + Arrays.toString(LTags) + ", nbTags=" + nbTags + ", date=" + date + ", auteur="
				+ auteur + "]";
	}

}
