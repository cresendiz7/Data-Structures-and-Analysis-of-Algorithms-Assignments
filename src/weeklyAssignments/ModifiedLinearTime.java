package weeklyAssignments;
public class ModifiedLinearTime {
	int startIndex, endIndex;
	int maximumSum;
	public ModifiedLinearTime(){
		startIndex = 0;
		endIndex = 0;
		maximumSum = 0;
	}
public ModifiedLinearTime maxSubSumLinear(int[] a){
	ModifiedLinearTime mlt = new ModifiedLinearTime();
	int thisSum =0;
	for(int j = 0; j < a.length; j++){
		thisSum += a[j];
		if(thisSum > mlt.maximumSum){
			mlt.endIndex = j;
			mlt.maximumSum = thisSum;
		}
		else if(thisSum < 0){
			thisSum = 0;
			if(mlt.startIndex < mlt.endIndex){
				mlt.startIndex = j + 1;
			}
		}
	}
	return mlt;
}
}