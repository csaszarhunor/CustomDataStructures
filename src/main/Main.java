package main;

import java.util.Iterator;

import collection.list.CustomArrayList;
import collection.set.CustomHashSet;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * test1 CustomArrayList
		 */
		// maintain the order of insertion
		CustomArrayList<String> list = new CustomArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println("list = " + list.toString());
		
		// items can be reached by index
		System.out.println("get(1) = " + list.get(1));
		
		// can contain null
		list.add(null);
		System.out.println("list = " + list.toString());
		
		// can contain duplicates
		list.add("two");
		System.out.println("list = " + list.toString());
		
		/*
		 * test2 CustomHashSet
		 */
		// doesn't maintain the order of insertion
		CustomHashSet<String> set = new CustomHashSet<>();
		set.add("one");
		set.add("two");
		set.add("three");
		System.out.println(set.size());
		System.out.println(set.toString());
		
		// can't contain duplicates
		set.add("two");
		System.out.println(set.size());
		System.out.println(set.toString());
		
		// can contain null
		set.add(null);
		System.out.println(set.size());
		System.out.println(set.toString());
		
		// items can be reached through iterator
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
	}
}
