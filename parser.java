package report;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class parser extends HttpServlet{
	/*
	public static String ExecutionType = "Daily Execution"; 
	public static String VM = "Machine";
	public static int TotalTC = 50;
	public static int notExcuted = 60;
	public static int Executed = 90;*/
	
	public List<String> executionTypeList = new ArrayList<String>();
	public List<String> vMList = new ArrayList<String>();
	public List<Integer> totalTCList = new ArrayList<Integer>();
	public List<Integer> notExcutedList = new ArrayList<Integer>();
	public List<Integer> executedList = new ArrayList<Integer>();
	
	public void init(ServletConfig config) throws ServletException {
		
		executionTypeList.add("Daily Execution 1");
		executionTypeList.add("Daily Execution 2");
		executionTypeList.add("Daily Execution 3");
		executionTypeList.add("Daily Execution 4");
		executionTypeList.add("Daily Execution 5");
		
		vMList.add("Machine 1");
		vMList.add("Machine 2");
		vMList.add("Machine 3");
		vMList.add("Machine 4");
		vMList.add("Machine 5");
		
		totalTCList.add(10);
		totalTCList.add(20);
		totalTCList.add(30);
		totalTCList.add(40);
		totalTCList.add(50);
		
		notExcutedList.add(60);
		notExcutedList.add(70);
		notExcutedList.add(80);
		notExcutedList.add(90);
		notExcutedList.add(100);
		
		executedList.add(110);
		executedList.add(120);
		executedList.add(130);
		executedList.add(140);
		executedList.add(150);
		
		
		File input = new File("C:/Workspace/PulseAndPenske/Jsoup/WebContent/tab.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8");
			
			Element ExecType = doc.getElementById("report");
			
			for(int i=0;i<executionTypeList.size();i++){
				ExecType.appendElement("tr><td>"+executionTypeList.get(i)+"</td><td>" +vMList.get(i) +"</td><td>"+ totalTCList.get(i) + "</td><td>"+notExcutedList.get(i)+"</td><td>"+executedList.get(i));
			}
			PrintWriter writer = new PrintWriter(input,"UTF-8");
			writer.write(doc.html()) ;
			writer.flush();
			writer.close();
			System.out.println("Done");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
   
    
}