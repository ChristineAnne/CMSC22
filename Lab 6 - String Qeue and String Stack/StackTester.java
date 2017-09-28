class StackTester{
	public static void main(String[] args){
		StringStack stack = new StringStack(10);
		stack.push("paper");
		stack.push("plastic");
		stack.push("tissue");

		System.out.println(stack);
		System.out.println(stack.size());

		String item1 = stack.pop();
		String item2 = stack.pop();
		String item3 = stack.pop();
		
		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
		System.out.println(stack);

		stack.push("Oz");
		//System.out.println(stack);

		String peek1 = stack.peek();
		System.out.println(peek1);

		stack.push("Toto");
		String peek2 = stack.peek();
		System.out.println(peek2);

		stack.push("Dorothy");
		String peek3 = stack.peek();
		System.out.println(peek3);

		System.out.println(stack);
		System.out.println(stack.pop(3));
		System.out.println(stack);
	}
}