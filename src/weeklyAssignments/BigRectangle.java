package weeklyAssignments;
import java.util.Comparator;

public class BigRectangle
{
	private static class Rectangle{
		private double height;
	    private double width;
	    
	    public Rectangle(double width, double height){
	        super();
	        this.height = height;
	        this.width = width;
	    }
	    public double getArea(){
	        return height * width;
	    }
	    public double getPerimeter(){
	        return 2 * (height + width);
	    }
	    @Override
	    public String toString(){
	        return "Rectangle [height=" + height + ", width=" + width + "]";
	    }
	}
	
	public static <E> E findMax(E[] array, Comparator<? super E> cmp){
	    int maxIndex = 0;
	    for (int i = 1; i < array.length; i++){
	        if (cmp.compare(array[i], array[maxIndex]) > 0){
	            maxIndex = i;
	        }
	    }
	    return array[maxIndex];
	}
	
	private static class AreaComparator implements Comparator<Rectangle>{
	    public int compare(Rectangle lhs, Rectangle rhs){	
	    	return Double.compare(lhs.getArea(), rhs.getArea());
	    }
	}
	
	private static class PerimeterComparator implements Comparator<Rectangle>{
	    public int compare(Rectangle lhs, Rectangle rhs){
	        return Double.compare(lhs.getPerimeter(), rhs.getPerimeter());
	    }
	}
	
	public static void main(String args[]) throws Exception
	{       
		System.out.println("Largest rectangle(Area): "+findMax(new Rectangle[] { new Rectangle(45, 65), new Rectangle(40, 100), new Rectangle(95, 125) }, new AreaComparator()));
		System.out.println("Largest rectangle(Perimeter): "+findMax(new Rectangle[] { new Rectangle(55, 95), new Rectangle(65, 25), new Rectangle(40, 100) }, new PerimeterComparator()));
	}
}
	   