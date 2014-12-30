package com.vs2.network.crudPost;

public class test {
	
	private static CrudPostList pList = CrudPostList.getInstance();
	
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pList.create(2, 3, "test inhalt2", "lisa", "test title");
		pList.create(1, 2, "test inhalt", "kevin", "title");
		
		Post p = pList.getElement(pList.searchById(2));
		
		p.setTitle("lisa title");
		pList.add(p);
		
		System.out.print(pList.toString());
	}

}
