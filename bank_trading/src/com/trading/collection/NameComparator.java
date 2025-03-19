package com.trading.collection;

import java.util.Comparator;

public class NameComparator implements Comparator<Employes> {

	@Override
	public int compare(Employes o1, Employes o2) {
		
	return String.compare(o1.getEmpNmae(),o2.getEmpNmae()); 
			
			
		
	}
	
	

}
