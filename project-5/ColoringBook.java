import java.util.ArrayList;

public class ColoringBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		
		//System.out.println(picture.length);
		ArrayList<ArrayList<ResList>> resLine = new <ArrayList<ResList>>ArrayList();
		
		
		//ResList[] a = new ResList[3];
				
		
		int temp=-1;
		
		for(int j=0;j<picture.length;j++) {
			ArrayList<ResList> res = new <ResList>ArrayList();

				for(int i=0;i<picture[j].length;i++) {
				//	int[] r = {0,0};
					ResList r = new ResList();
				
					if(picture[j][i] == temp) {
						
						res.get(res.size() - 1).pair[1]++;
						res.get(res.size() - 1).index.add(i);
					
					} else {
						temp=picture[j][i];
						r.pair[0] = temp;
						r.pair[1]++;
						r.index.add(i);
						res.add(r);
					}
				}
				

			resLine.add(res);
	
				
		}
				
		//System.out.println("aa");
			
		for(int i=resLine.size()-1;i>0;i--) { // 마지막 줄부터 첫번째줄 까지  순서로
			for(int j=0;j<resLine.get(i-1).size();j++) { //비교하는 줄의 위에 줄 -> 첫번재 인덱스부터 마지막까지
				for(int k=0;k<resLine.get(i).size();k++) { // 비교하는 줄 (마지막 줄부터 시작) -> 첫번째 인덱스부터 마지막까지
					if(resLine.get(i-1).get(j).pair[0] == resLine.get(i).get(k).pair[0]) {
						if(compareNum(resLine.get(i-1).get(j).index, resLine.get(i).get(k).index)) {
							resLine.get(i-1).get(j).pair[1] += resLine.get(i).get(k).pair[1];
							resLine.get(i).remove(k);
						}
							
					}
				}
			}
		}
		
		
		//System.out.println("dd");
		
		/* 출력
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i).pair[0] + "," + res.get(i).pair[1] + " === ");
			for(int j=0;j<res.get(i).index.size();j++)
			System.out.print(res.get(i).index.get(j) + " ");
			System.out.println();
		}*/
		
		int big = findBig(resLine);
		int areaNum = findArea(resLine);
		
		System.out.println("영역 갯수 : " + areaNum + ", 최대 영역 크기 : " + big);
		//System.out.println(");
		
		
	}
	
	public static boolean compareNum(ArrayList a, ArrayList b) { // 아랫줄과 그 위엣줄에 있는 숫자들이 붙어있냐 아니냐 판별
		
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<b.size();j++) {
				if(a.get(i)==b.get(j))
					return true;
			}
		}
		
	
			return false;
	}

	
	public static int findBig(ArrayList<ArrayList<ResList>> a) {
		int bigNum=0;
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.get(i).size();j++) {
				if(a.get(i).get(j).pair[1] >= bigNum)
					bigNum = a.get(i).get(j).pair[1];
			}
		}
		
		return bigNum;
	}
	
	public static int findArea(ArrayList<ArrayList<ResList>> a) {
		int sum = 0;
		
		for(int i=0;i<a.size();i++) {
			sum += a.get(i).size();
		}
		
		return sum;
	}
}
