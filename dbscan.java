//Cluster

public class cluster {
      int id=0;  
      ArrayList<Boolean> isMember= new ArrayList<>(Collections.nCopies(312,false ));   
      public cluster(){      
      }    
      public cluster(int id) {     
          this.id = id; 
      } 
}

//Dbscan 

import java.io.*;
import java.util.*; 

public class dbscan {
     
public ArrayList<Boolean> visited=new ArrayList<>(Collections.nCopies(20,false)); 
public ArrayList<Boolean> isNoise=new ArrayList<>(Collections.nCopies(20,false));  
cluster c1= new cluster(1);  
cluster c2= new cluster(2);      

    public static void main(String[] args) {  
        String path = "C:\\Users\\PAYAL\\Desktop\\DWM Project (Sem V)\\dbscan.csv";      
        String line = "";      
        double [][] arr_pts=new double[20][2];   
        float eps= 0.06f;    
        int min_pts=3;   
        try {            
            BufferedReader br = new BufferedReader(new FileReader(path)); 
            int i=0;           
            while ((line = br.readLine()) != null && i<20) {          
                String[] values = line.split(",");            
                arr_pts[i][0]=Double.parseDouble(values[0]); 
                arr_pts[i][1]=Double.parseDouble(values[1]);            
                i++;      
            }      
        } catch (FileNotFoundException e) {       
            e.printStackTrace();      
        } catch (IOException e) {      
            e.printStackTrace();       
        }     
        dbscan exp= new dbscan();      
        exp.DBSCAN(arr_pts,eps,min_pts);     
        for(int index=0;index<20;index++){        
            if(exp.c1.isMember.get(index)){            
                System.out.println(index+" "+"x= "+arr_pts[index][0]+" "+"y= " +arr_pts[index][0]+" "+"Cluster: C1");      
            }else{             
                System.out.println(index+" "+"x= "+arr_pts[index][0]+" "+"y= " +arr_pts[index][0]+" "+"Cluster: C2");    
            }  
        }   
    }
    
    public void DBSCAN(double[][] arr_pts,float eps,int min_pts){    
        cluster c= new cluster();       
        for(int i=0;i<arr_pts.length;i++){    
            if(!visited.get(i)){          
                visited.add(i,true);        
                List<Double> point=new ArrayList<Double>();       
                point.add(arr_pts[i][0]);            
                point.add(arr_pts[i][1]);         
                ArrayList<List<Double>> neighborPts=new ArrayList<List<Double> >();       
                neighborPts= regionQuery(point, eps, arr_pts);              
                double[] p={point.get(0),point.get(1)};      
                if(neighborPts.size()<min_pts){          
                    isNoise.add(i,true);      
                }           
                else{           
                    if(c.id==1){    
                        c=c2;           
                        expandCluster(p, neighborPts, c, eps, min_pts, arr_pts );       
                    }else{             
                        c=c1;            
                        expandCluster(p, neighborPts, c, eps, min_pts, arr_pts );      
                    }        
                } 
            }        
        }     
    }   
    
    public void expandCluster(double[] p,ArrayList<List<Double>> neighborPts, cluster c,float eps,int min_pts,double arr_pts[][]){   
    int index=getIndex(p, arr_pts);      
    if(index!=-1){      
        c.isMember.add(index,true);     
        for(int i=0;i<neighborPts.size();i++){      
            if(!visited.get(i)){             
                visited.add(i,true);         
                ArrayList<List<Double>> neighborNewPts=new ArrayList<List< Double>>();         
                neighborNewPts=regionQuery(neighborPts.get(i), eps, arr_pts);              
                if(neighborNewPts.size()>=min_pts){          
                    neighborPts.addAll(neighborNewPts);          
                }             
            }              
            double[] p1={neighborPts.get(i).get(0),neighborPts.get(i).get( 1)};     
            if(!(c1.isMember.get(getIndex(p1,arr_pts))) && !(c2.isMember.get(getIndex(p1,arr_pts)))){   
            c.isMember.add(getIndex(p1,arr_pts),true);          
        }           
        }     
    }    
}  
    public ArrayList<List<Double>> regionQuery(List<Double> p,float eps,double [][] arr_pts){   
        int n=arr_pts.length;      
        ArrayList<List<Double>> list_pts=new ArrayList<List<Double>>();  
        list_pts.add(p); 
        for(int i=0;i<n;i++){ 
            double[] p1={p.get(0),p.get(1)};      
            double[] p2=arr_pts[i];        
            if(calculateDist(p1, p2)<eps){     
                List<Double> element= new ArrayList<Double>(); 
                element.add(p2[0]);            
                element.add(p2[1]);           
                list_pts.add(element);       
            }      
        }       
        return list_pts;  
    }  
    public float calculateDist(double[] p1,double[] p2){       
        float dist = (float)(Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]));  
        return dist;   
    }  
    
    public int getIndex(double[] p,double[][] arr_pts){       
        for(int i=0;i<arr_pts.length;i++){         
            if(p[0]==arr_pts[i][0] && p[1]==arr_pts[i][1]){       
                return i;         
            }      
        }      
        return -1;   
    }  
} 
