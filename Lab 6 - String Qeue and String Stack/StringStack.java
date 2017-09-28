/*
	Christine Anne Catubig
	Ricafelle Dorothy Fortes
*/

import java.lang.StringBuffer;

class StringStack{
	private String[] items;
	private int count = 0;
	public static final int DEFAULT_SIZE = 10;

	StringStack(){
		items = new String[DEFAULT_SIZE];
	}

	StringStack(int size){
		if(size <= 0){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			items = new String[size];
		}
	}

	void push(String item){
		if(count >= items.length){
			expand();
		}
		items[count] = item;			
		count++;
		
	}

	String pop(){
		if(count <= 0){
			throw new ArrayIndexOutOfBoundsException(); 
		}else{
			String temp = "";
			temp = items[count-1];
			count--;
			return temp;
		}
	}

	String pop(int n){
		String temp = "";
		if(count < n){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			for(int i = 1; i <= n; i++){
				temp = pop();
			}	
			return temp;
		}
	}

	String peek(){
		return items[count-1];
	}

	void expand(){
		String[] temp = new String[count]; // temporary String array 
		for(int i = 0; i < count; i++){
			temp[i] = items[i];
			pop(); 
		}

		items = new String[count + 5]; // allocates a bigger memory chunk for items
		for(int i = 0; i < count; i++){ // copies the value of temp unto items
			push(temp[i]);
		}
	}

	int size(){
		return count;
	}

	public String toString(){
		if(count <= 0){
			return "Empty";
		}else{
			StringBuffer value = new StringBuffer();
			for(int i = 0; i < count-1; i++){
				value.append(items[i] + ", ");
			}
			value.append(items[count-1]);
			String str = new String(value);
			return str;
		}
	}

}