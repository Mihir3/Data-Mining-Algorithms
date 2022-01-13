package nbclassifier;

import java.sql.*;
import java.util.*; 
import java.io.*;
/**
 *
 * @author PAYAL
 */
public class nbc {

    /**
     *
     * @param args
     */
public static void main(String[] args) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
            
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nb","root","");
    
    Statement s = con.createStatement();      
    String query = null;      
    ResultSet rs = null;     
    int c1=0 ,c2=0 ,n=0; 
    
    query ="SELECT COUNT(*) AS Expr1 FROM custanalysis WHERE (decision = 'YES') ";    
    s.execute(query);       
    rs= s.getResultSet();    
    if(rs.next())           
        c1=Integer.parseInt(rs.getString(1)); 
    
    query ="SELECT COUNT(*) AS Expr1 FROM custanalysis WHERE (decision = 'NO') ";    
     s.execute(query);       
     rs= s.getResultSet(); 
     if(rs.next())         
         c2=Integer.parseInt(rs.getString(1));
     
    query = "SELECT COUNT(*) AS Expr1 FROM custanalysis ";     
    s.execute(query);      
    rs= s.getResultSet();  
    if(rs.next())      
        n = Integer.parseInt(rs.getString(1)); 
    
    float pyes = (float)c1/n;     
    float pno = (float)c2/n; 
    
    String path = "C:\\Users\\PAYAL\\Desktop\\DWM Project (Sem V)\\testset.csv";    
    String line = "";       
    
    ArrayList<String> item= new ArrayList<>(499);   
    ArrayList<String> age = new ArrayList<>(499);    
    ArrayList<String> decision = new ArrayList<>(499);      
    ArrayList<String> predicted= new ArrayList<>(499); 
    
    try {  
        BufferedReader br = new BufferedReader(new FileReader(path));      
        while ((line = br.readLine()) != null) {     
            String[] values = line.split(",");     
            age.add(values[0]);             
            item.add(values[1]);       
            decision.add(values[2]);              
        }         
    } catch (FileNotFoundException e){            
        e.printStackTrace();   
    } catch (IOException e) {  
        e.printStackTrace();    
    }      
    item.remove(0);        
    age.remove(0);     
    decision.remove(0);     
    
    for(int i=0; i<500;i++)
    {        
 //calculate the probability of yes and no for given scenario of test dataset and compare to predict result for given tuple      
     
        if(i == 499){
            break;
        }
        float pyesGivenx = pcalc(item.get(i), age.get(i),"YES")*pyes;
        float pnoGivenx = pcalc(item.get(i),age.get(i),"NO")*pno;  
        
        if(pyesGivenx > pnoGivenx){
            predicted.add(i,"YES");  }          
        else {
            predicted.add(i,"NO");    }
    }  
    int tp=0,tn=0,fp=0,fn=0; 
    
 //Calculate the Confusion Matrix,Precision,Accuracy,Recall of the model    
    for(int i=0;i<500;i++){ 
       
        if(i == 499){
            break;
        }
        if((decision.get(i).equals(predicted.get(i))) && (decision.get(i).equals("YES"))) 
            tp++;      
        else if(decision.get(i).equals("NO") && decision.get(i).equals(predicted.get(i)))
            tn++;            
        else if(decision.get(i).equals("YES") && !decision.get(i).equals(predicted.get(i))) 
            fp++;           
        else 
            fn++;        
    }       
    int[][] confusionMatrix= {{tp,fn},{fp,tn}};  
    float accuracyOfModel= (float)(tp+tn)/499;  
 
//Predict on the basis of user input     
     System.out.println("Naive Bayes Classification model - ");     
     System.out.println("Confusion Matrix: ");    
     for(int[] row: confusionMatrix){   
         for(int cell: row){    
             System.out.print("[ "+cell+" ]");      
         }          
         System.out.println();        
     }  
     System.out.println("Accuracy: "+accuracyOfModel);  
     System.out.println("Predict based on user input: ");   
     Scanner input= new Scanner(System.in);       
     System.out.println("Menu - \n"
             + "111 : Burger \n" 
             + "112 : Pizza \n"
             +"113 : Hamburger \n"
             + "114 : Pasta \n"
             + "115 : Popcorn \n");
     System.out.println("Enter the item name: "); 
     String inputItem= input.next();       
     System.out.println("Enter the age(Young/Adult/Senior): ");     
     String inputAge = input.next();
     
    float probGivenYes = pcalc(inputItem,inputAge,"YES")*pyes;   
    float probGivenNo = pcalc(inputItem,inputAge,"NO")*pno; 
    
    if(probGivenNo > probGivenYes)
           System.out.println("The person is not going to buy the food item."); 
       else 
            System.out.println("The person is going to buy the food item.");   
    s.close();       
    con.close(); 
    }
    
public static float pcalc (String item, String age, String decision) throws ClassNotFoundException, SQLException{
    float res = 0f;
    
    Class.forName("com.mysql.jdbc.Driver");
            
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nb","root","");
    
    Statement s = con.createStatement();      
    String query = null;      
    ResultSet rs = null;     
    int c1=0 ,c2=0 ,n=0; 
    int y=0,z=0,total=0;
    String w,v,t;
    
 //calculate the total number of a class of items for given decision option(yes/no)      
 query ="SELECT  COUNT(*) AS Expr1 FROM custanalysis WHERE ((item = '"+ item +"' ) AND (decision = '" +decision +"')) ";   
 s.execute(query);            
 rs= s.getResultSet(); 
 while(rs.next()){ 
    w = rs.getString(1);
    y = Integer.parseInt(w);
     }

   
//calculate the total number of a class of age for given decision option(yes/no)  
query ="SELECT COUNT(*) AS Expr1 FROM custanalysis WHERE ((age ='"+ age + "' ) AND (decision = '" +decision +"')) ";      
s.execute(query);  
rs = s.getResultSet(); 
while(rs.next()){
    v = rs.getString(1);
    z = Integer.parseInt(v); }
    


 //calculate total yes/no from training dataset        
 query ="SELECT COUNT(*) AS Expr1 FROM custanalysis WHERE(decision = '" +decision +"') ";  
 s.execute(query);           
 rs= s.getResultSet();        
 while(rs.next()){ 
     t = rs.getString(1);
    total = Integer.parseInt(t); }
 
res = (float)y / (float)total  * (float)z /(float)total  ;

 s.close();   
 con.close(); 
 return res;
}

    
}
 
