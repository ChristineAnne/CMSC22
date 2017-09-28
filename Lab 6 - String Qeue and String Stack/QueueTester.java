class QueueTester{
	public static void main(String[] args){
		StringQueue stack = new StringQueue();
		stack.enqueue("paper");
		stack.enqueue("plastic");
		stack.enqueue("tissue");

		System.out.println(stack);
		System.out.println(stack.size());

		String item1 = stack.dequeue();
		String item2 = stack.dequeue();
		String item3 = stack.dequeue();
		
		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
		System.out.println(stack);

		stack.enqueue("Oz");
		//System.out.println(stack);

		String peek1 = stack.peek();
		System.out.println(peek1);

		stack.enqueue("Toto");
		String peek2 = stack.peek();
		System.out.println(peek2);

		stack.enqueue("Dorothy");
		String peek3 = stack.peek();
		System.out.println(peek3);

		System.out.println(stack);

		stack.singit(3, "The Wizard");
		System.out.println(stack);

		
	}
}