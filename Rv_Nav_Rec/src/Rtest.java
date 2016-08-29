import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;


public class Rtest
{
      
	public static void main(String...args)
	{
		
		int k=0;
		DescriptiveStatistics stats = new DescriptiveStatistics();

		// Add the data from the array
		for (int i = 0; i < 6; i++)
		{
			
			stats.addValue(++k);
			System.out.println("val--"+k);
		}

		double sampleRMS = stats.getStandardDeviation();

		System.out.println("SD-->"+sampleRMS);
		
//		Object acceleration = null;
//		double sampleMean = StatUtils.mean((double[]) acceleration);
//		
//		System.out.println("Mean-->"+sampleMean);

//		sampleMax = StatUtils.max(acceleration);
//		sampleMin = StatUtils.min(acceleration);
		
	   
//		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
//		double[] y = new double[]{11.0, 12.0, 13.0, 14.0, 15.0, 16.0};
//		double[][] x = new double[6][];
//		x[0] = new double[]{0, 0, 0, 0, 0};
//		x[1] = new double[]{2.0, 0, 0, 0, 0};
//		x[2] = new double[]{0, 3.0, 0, 0, 0};
//		x[3] = new double[]{0, 0, 4.0, 0, 0};
//		x[4] = new double[]{0, 0, 0, 5.0, 0};
//		x[5] = new double[]{0, 0, 0, 0, 6.0};          
//		regression.newSampleData(y, x);
//		
//		double[] beta = regression.estimateRegressionParameters();       
//
//		double[] residuals = regression.estimateResiduals();
//
//		double[][] parametersVariance = regression.estimateRegressionParametersVariance();
//
//		double regressandVariance = regression.estimateRegressandVariance();
//
//		double rSquared = regression.calculateRSquared();
//
//		double sigma = regression.estimateRegressionStandardError();
//		
//		System.out.println("<---COMPlete---->");
//		System.out.println("Beta SIze-->>"+beta.length);
//		for(double cc : beta)
//		{
//			System.out.println("Beta Val-->"+cc);
//		}
//		
//		
//		System.out.println("Residuals SIze-->>"+residuals.length);
//		for(double cc : residuals)
//		{
//			System.out.println("Residuals Val-->"+cc);
//		}
//		
////		System.out.println("ParaMeter Varience SIze-->>"+parametersVariance.length);
////		for(double cc : parametersVariance)
////		{
////			System.out.println("ParaMeter Varience Val-->"+cc);
////		}
//		
//		System.out.println("Regress and Varience-->>"+regressandVariance);
//		
//		System.out.println("R SquareD-->"+rSquared);
//		
//		System.out.println("Sigma-->"+sigma);
		
		
	}
	
	
}
