public class ModifiedQuadratic {
	int startIndex, endIndex;
	int maximumSum;
	public ModifiedQuadratic(){
		startIndex = 0;
		endIndex = 0;
		maximumSum = 0;
	}
public ModifiedQuadratic maxSubSumQuad(int[] a){
	ModifiedQuadratic mq = new ModifiedQuadratic();
	for(int i = 0; i < a.length; i++){
		int thisSum = 0;
		for(int j = i; j < a.length; j++){
			thisSum += a[j];
			if(thisSum > mq.maximumSum){
				mq.startIndex = i;
				mq.endIndex = j;
				mq.maximumSum = thisSum;
			}
		}
	}
	return mq;
}
}