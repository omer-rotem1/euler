package euler;




public class Vertex implements Comparable<Vertex>{
	public int x;
	public int y;
    public double minDistance = Double.POSITIVE_INFINITY;

	
	public Vertex(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public boolean equals(Vertex p) {
		if (this.x!=p.x) return false;
		if (this.y!=p.y) return false;
		return true;
	}
	
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}
