package Graph;

public class Graph {
	private int[][] matrix;
	private int size;
	
	public Graph(int size)
	{
		this.matrix = new int[size][size];
		this.size = size;
	}
	
	public void add(int i , int k)
	{
		if(matrix[i][k] == 0)
		{
			matrix[i][k] = 1;
			matrix[k][i] = 1;
		}
		else
		{
			System.out.println("This is falut insert");
		}
	}
	public void delete(int i , int k)
	{
		if(matrix[i][k] == 1)
		{
			matrix[i][k] = 0;
			matrix[k][i] = 0;
		}
		else
		{
			System.out.println("This is fault delete");
		}
	}
	
	public void show()
	{
		if(this.size == 0)
		{
			System.out.println("No Matrix");
			return;
		}
		for(int i = 0 ; i < size ; i++)
		{
			String temp="";
			for(int j = 0 ; j < size ; j++)
			{
				if(this.matrix[i][j] == 1)
				{
					temp += j + " ";
				}
			}
			if (!temp.equals(""))
			{
				System.out.println(i + " : " + temp);
			}
		}
	}
}
