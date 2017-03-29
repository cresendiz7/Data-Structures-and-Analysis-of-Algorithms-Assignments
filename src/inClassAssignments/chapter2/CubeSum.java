package inClassAssignments.chapter2;

public class CubeSum {

	public static void main(String[] args) {
		System.out.println(sum(2));//1^3+2^3
		System.out.println(sum(3));//1^3+2^3+3^3
		System.out.println(sum(4));//1^3+2^3+3^3+4^3
		System.out.println(sum(5));//1^3+2^3+3^3+4^3+5^3

	}
	public static int sum(int n)//F(N) = 0 + 1 + N + 1 = O(N)
	{
		int partialSum;//zero time
		partialSum = 0;//one time = O(1)
		for(int i = 1; //one time = O(1)
				i <= n; //N + 1 times = O(N+1) = O(N)
				i++//N time = O(N)
				)//F(N) = 1 + (N+1) + N = 2 + 2N = O(N)
		{
			//for loop is O(N) * work inside of loop

			partialSum += i*i*i;//four time = O(4) = O(1)
		}
		return partialSum;//one time = O(1)
	}
}
