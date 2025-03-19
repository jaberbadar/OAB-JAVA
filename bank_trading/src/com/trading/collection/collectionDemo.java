package com.trading.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class collectionDemo {

	public static void main(String[] args) {
		
		
		
		
//		List<String>names= new ArrayList<>();

		
	//	Set<String>names= new HashSet<>(); //not 2coby
		
		
		Set<String>names= new TreeSet<>();  //order

		names.add("ahmed");
		names.add("hassan");
		names.add("ali");
		names.add("fatimah");
		names.add("ali");
	
		
		
		for(String name:names) {
			System.out.println(name);
		}


		
		
	//	Set<Employes> empSet= new HashSet<>();
	//	Set<Employes> empSet= new TreeSet<>();
		List<Employes> empSet= new ArrayList<>();

		empSet.add(new Employes(101, "ahmed", "it", 2000));
		empSet.add(new Employes(102, "sara", "sales", 2000));
		empSet.add(new Employes(103, "talai", "accounts", 2500));

		empSet.add(new Employes(104, "eman", "it", 2000));
		empSet.add(new Employes(101, "harith", "it", 2000));
	//	Collections.sort(empSet);
	Collections.sort(empSet,new NameComparator());

		

		for(Employes smp:empSet) {
			System.out.println(smp);
		}

 
//print all names

//Iterator<String> iter = names.iterator();
//while(iter.hasNext()) {
//	System.out.println(iter.next());
//}
		
		
//print all names







			
	}

}
