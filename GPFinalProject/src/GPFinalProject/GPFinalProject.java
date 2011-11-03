package GPFinalProject;

public class GPFinalProject 
{

	/**
	 * @param args
	 */
	final static private String operators = "+-/*";
	public static GPNode generateNode(int depth)
	{
		int num = Utilities.GetRandomNumber(0, 10);
		// num < 8 to cause 80% probability of an operator, but don't let the tree get more than 6 levels deep
		if ((num < 8) && (depth < 6))
		{
			GPNode left = generateNode(depth + 1);
			GPNode right = generateNode(depth + 1);
			num = Utilities.GetRandomNumber(0, 3);
			String operator = operators.substring(num,num+1);
			GPNodeOperator myNode = new GPNodeOperator(operator, left, right);
			return myNode;
		}
		else
		{
			num = Utilities.GetRandomNumber(0, 9);
			
			if (num < 2)
			{
				GPNodeValue myNode = new GPNodeValue("X");
				return myNode;
			}
			else
			{
				num = Utilities.GetRandomNumber(1, 10);
				GPNodeValue myNode = new GPNodeValue(num);
				return myNode;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
/*		
//		Code to manually generate a tree
		GPNodeValue leftBranchLeftValue = new GPNodeValue(5.0);
		GPNodeValue leftBranchRightValue = new GPNodeValue(-7.0);
		GPNodeOperator leftBranch = new GPNodeOperator("/", leftBranchLeftValue, leftBranchRightValue);
		GPNodeValue rightBranchLeftValue = new GPNodeValue("X");
		GPNodeValue rightBranchRightValue = new GPNodeValue(9);
		GPNodeOperator rightBranch = new GPNodeOperator("-", rightBranchLeftValue, rightBranchRightValue);
		GPNodeOperator treeTop = new GPNodeOperator("+", leftBranch, rightBranch);
*/
		GPNode treeTop = GPFinalProject.generateNode(0);
		
		System.out.println("Depth: " + treeTop.GetGPDepth());
		System.out.println("Node Count: " + treeTop.GetGPNodeCount());
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Evaluated for X=20: " + treeTop.EvaluateFitnessValue(20));

		
/*		
//		Checkout for the random number generator
		for (int i = 0; i < 20; i++)
		{
			System.out.println(Utilities.GetRandomNumber(6, 14));
		}
*/		
	}

}
