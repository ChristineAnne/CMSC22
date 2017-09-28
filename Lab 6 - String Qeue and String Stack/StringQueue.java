/*
	Christine Anne Catubig
	Ricafelle Dorothy Fortes
*/

import java.lang.StringBuffer;

public class StringQueue{
	private int count;
	private String[] elements;
	public static final int DEFAULT_SIZE = 10;

	StringQueue() {
		elements = new String[DEFAULT_SIZE];
	}

	String dequeue() {
		if(count <= 0){
			throw new ArrayIndexOutOfBoundsException(); 
		}else{
			String temp = elements[0];
			for(int i = 0; i < count-1; i++){
				elements[i] = elements[i+1];
			}
			elements[count] = "\0";
			count--;
			
			return temp;
		}
	}

	String dequeue(int n) {
		String temp = "";
		if(count < n){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			for(int i = 1; i <= n; i++){
				temp = dequeue();
			}	
			return temp;
		}
	}

	int size() {
		return count;
	}

	public String toString() {
		if(count <= 0){
			return "Empty";
		}else{
			StringBuffer value = new StringBuffer();
			for(int i = 0; i < count-1; i++){
				value.append(elements[i] + ", ");
			}
			value.append(elements[count-1]);
			String str = new String(value);
			return str;
		}
	}

	String peek() {
		return elements[0];
	}

	void enqueue(String item) {
		if(count >= elements.length){
			expand();
		}

		elements[count] = item;			
		count++;
		
	}

	void expand(){
		String[] temp = new String[count]; // temporary String array 
		for(int i = 0; i < count-1; i++){
			temp[i] = elements[i];
			dequeue(); 
		}

		elements = new String[count + 5]; // allocates a bigger memory chunk for elements
		for(int i = 0; i < count; i++){ // copies the value of temp unto elements
			enqueue(temp[i]);
		}
	}


	void singit(int position, String item) {
		if(count >= elements.length){
			expand();
		}
		
		for(int i = count; i >= position; i--){ // shifts the items in elements[] to the right
			elements[i+1] = elements[i];
		}

		elements[position] = item; 
		count++;
	}
}