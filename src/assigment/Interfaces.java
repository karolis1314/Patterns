package assigment;

//Interfaces for my patterns.

interface Visitor {
	public void visit(Visitable visitable);
}

interface Visitable {
	public void accept(Visitor visitor);
}

interface Iterator {
	boolean hasNext();
	Object next();
}

interface Container {
	Iterator iterator();
}
