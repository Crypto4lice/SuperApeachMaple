import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class FilteringRecord {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		List<Record> list = new ArrayList<Record>();
		
		Record rec = new Record("John Johnsin", "Manager", "2016-12-31");
		Record rec2 = new Record("Jake Jacobson", "Programmer", "");
		list.add(rec);
		list.add(rec2);

		

		
		String srch=null;
		int option=0;
		
		System.out.println("1.Name   2.Position");
		System.out.print("Select Searching Option : ");
		srch = s.nextLine();
		
		
		String[] res = {null,null,null};
		
		
		while(true) {
			option = Integer.parseInt(srch);
			if(option>0 && option<4) {
				res = search(option, list, res);
				break;
			}
			else {
				System.out.println("Wrong number.");
				System.out.print("Select Searching Option : ");
				option = Integer.parseInt(s.nextLine());
			}
		}
		
		
		
		printR(res);
		
		
		
	}
	
	public static String[] search(int option, List<Record> list, String[] res){
		String search=null;
		
		if(option==1) {
			System.out.print("Enter a search name : ");
			search = s.nextLine();
			
			for(int i=0;i<list.size();i++) {
				if( list.get(i).getName().contains(search) == true) {
					res[0] = list.get(i).getName();
					res[1] = list.get(i).getPosition();
					res[2] = list.get(i).getSeparation();
				}
			}
		} else if(option==2) {
			System.out.print("Enter a search position : ");	
			search = s.nextLine();
			
			for(int i=0;i<list.size();i++) {
				if( list.get(i).getPosition().contains(search) == true) {
					res[0] = list.get(i).getName();
					res[1] = list.get(i).getPosition();
					res[2] = list.get(i).getSeparation();
				}
			}
		} else if(option==3) {
			String[] d;
			String ss;
			for(int i=0;i<list.size();i++) {
				d = list.get(i).getSeparation().split("-");
				ss = list.get(0).getSeparation().replace("-", "");
				
				try {
				SimpleDateFormat dateFor = new SimpleDateFormat("yyyyMMdd");
				Calendar c1 = Calendar.getInstance();
				String tod = dateFor.format(c1.getTime());
				
				
				Date begin = (Date) dateFor.parse(ss);
				Date end = (Date) dateFor.parse(tod);
				
				long diff = end.getTime() - begin.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				System.out.println(diff);
				System.out.println(diffDays);
				} catch(ParseException e) {
					e.printStackTrace();
				}
			}
		}
			
		
		return res;
	}
	
	public static void printR(String[] res) {
		System.out.println("Results:\n");
		
		if(res[0] == null)
			System.out.println("Not found.");
		else {
		
		System.out.println("Name                   | Position               "
				+ "| Separation Date        ");
		System.out.println("---------------------------------------------------"
				+ "----------------------");
		
		if(res[0].length()<23)
			res[0] = makeLine(res[0]);
		if(res[1].length()<23)
			res[1] = makeLine(res[1]);
		if(res[2].length()<23)
			res[2] = makeLine(res[2]);
		
		System.out.println(res[0]+"| "+res[1]+"| "+res[2]);
		}
	}
	
	public static String makeLine(String target) {
		String addSpace = " ";
		for(int i=0;i<22-target.length();i++)
			addSpace = addSpace + " ";
		target = target + addSpace;
		
		return target;
	}

}
