import java.util.*;
public class kmeans {
      
    List<Record> data = new ArrayList<Record>();   
    List<Cluster> clusters = new ArrayList<Cluster>();   
    Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>(); 
    
    public static void main(String[] args) {  
        int clusterNumber = 3;  
        kmeans model = new kmeans();      
        model.genereateRecord();    
        model.initiateClusterAndCentroid(clusterNumber);  
        model.printRecordInformation();   
    }  
    
    private void genereateRecord() {  
        Record record = new Record(1, 30, 1000);
             data.add(record);      
             record = new Record(2, 42, 500);  
             data.add(record);     
             record = new Record(3, 20, 600);  
             data.add(record);      
             record = new Record(4, 15, 450);      
             data.add(record);       
             record = new Record(5, 25, 800);  
             data.add(record);   
             record = new Record(6, 32, 200);     
             data.add(record);      
             record = new Record(7, 45, 730);   
             data.add(record);    
             record = new Record(8, 23, 360 ); 
             data.add(record);      
             record = new Record(9, 18, 540);    
             data.add(record);       
             record = new Record(10, 22, 250);    
             data.add(record);  
             record = new Record(11, 33, 380);    
             data.add(record); 
             record = new Record(12, 40, 250);    
             data.add(record); 
             record = new Record(13, 27, 445);    
             data.add(record); 
             record = new Record(14, 35, 292);    
             data.add(record); 
             record = new Record(15, 29, 625);    
             data.add(record); 
             record = new Record(16, 43, 882);    
             data.add(record); 
             record = new Record(17, 28, 336);    
             data.add(record); 
             record = new Record(18, 37, 994);    
             data.add(record); 
             record = new Record(19, 44, 280);    
             data.add(record); 
             record = new Record(20, 39, 430);    
             data.add(record); 
    }  
    private void initiateClusterAndCentroid(int clusterNumber) {     
        int counter = 1;
        Iterator<Record> iterator = data.iterator();      
        Record record = null;  
        
        while(iterator.hasNext()) {     
            record = iterator.next();
            if(counter <= clusterNumber) {   
                record.setClusterNumber(counter);
                initializeCluster(counter, record); 
                counter++;     
            }else {      
                int minDistance = Integer.MAX_VALUE;
                Cluster whichCluster = null; 
                
                for(Cluster cluster : clusters) {    
                    int distance = cluster.calculateDistance(record);
                    if(minDistance > distance) {  
                        minDistance = distance;
                        whichCluster = cluster;                     }                 }
                
                record.setClusterNumber(whichCluster.getClusterNumber());           
                whichCluster.updateCentroid(record);             
                clusterRecords.get(whichCluster).add(record);  
                
            }  
        }  
    }  
    
    private void initializeCluster(int clusterNumber, Record record) { 
        Cluster cluster = new Cluster(clusterNumber,record.getAge(),record.getTransaction());      
        clusters.add(cluster);      
        List<Record> clusterRecord = new ArrayList<Record>();    
        clusterRecord.add(record);    
        clusterRecords.put(cluster, clusterRecord); 
        
    }  
    
    private void printRecordInformation() {  
        System.out.println("****** CLUSTER TABLE *********");
        int RowId=1;  
        for(Record record : data) {       
            int i=1;
            System.out.println("Record= "+RowId);   
            for(Cluster cluster: clusters){         
                int distance = cluster.calculateDistance(record);
                System.out.println("Distance From Cluster "+i+"= "+distance);  
                i++;            
            }         
            RowId++;      
        }       
        for(Record record: data){      
            System.out.println(record);
        }    
    } 
    
    
public class Record {  

    private int id;   
    private int age;    
    private int transaction;  
    private int clusterNumber;  
    
    public Record(int id, int age, int transaction) {  
        super(); 
        this.id = id;     
        this.age = age;     
        this.transaction = transaction;   
    }     public int getId() {   
        return id;
    } 
    public void setId(int id) {     
        this.id = id;
    }   
    public int getAge() {    
        return age;
    }    
    public void setAge(int age) {     
        this.age = age;
    }   
    public int getTransaction() {    
        return transaction;
    }  
    public void setIncome(int transaction) {     
        this.transaction = transaction;
    }    
    public int getClusterNumber() {  
        return clusterNumber;
    }   
    public void setClusterNumber(int clusterNumber) { 
        this.clusterNumber = clusterNumber;
    }   
    @Override   
    public String toString() {          
        if(clusterNumber==3){          
            return "Record [id=" + id + ", age=" + age + ", transaction=" + transaction +  ", clusterId= KFC, clusterNumber= "                     + clusterNumber + "]";
        }
        else if(clusterNumber == 2){    
    return "Record [id=" + id + ", age=" + age + ", transaction=" + transaction +  ", clusterId= Subway, clusterNumber= "                     + clusterNumber + "]";
         }  
        else{
    return "Record [id=" + id + ", age=" + age + ", transaction=" + transaction +  ", clusterId= McDonalds, clusterNumber= "                     + clusterNumber + "]";        
        }
        
    }
}
  
public class Cluster {  
    private int ageCentroid;
    private int transactionCentroid;   
    private int clusterNumber;   
    public Cluster(int clusterNumber, int ageCentroid, int transactionCentroid) {      
        super();
        this.clusterNumber = clusterNumber;     
        this.ageCentroid = ageCentroid;  
        this.transactionCentroid = transactionCentroid; 
    }  
    public int getAgeCentroid() {  
        return ageCentroid;
    }  
    public void setAgeCentroid(int ageCentroid) {  
        this.ageCentroid = ageCentroid;
    }  
    public int getTransactionCentroid() {     
        return transactionCentroid;
    }  
    public void setTransactionCentroid(int TransactionCentroid) { 
        this.transactionCentroid = transactionCentroid;
    }  
    public int getClusterNumber() {  
        return clusterNumber;
    }  
    public void setClusterNumber(int clusterNumber) {    
        this.clusterNumber = clusterNumber;
    }  
    public int calculateDistance(Record record) {  
        return (Math.abs(getAgeCentroid() - record.getAge()) + Math.abs((getTransactionCentroid() - record.getTransaction())));
    }  
    public void updateCentroid(Record record) {     
        setAgeCentroid((getAgeCentroid() + record.getAge()) / 2);
        setTransactionCentroid((getTransactionCentroid() + record.getTransaction()) / 2); 
    }
  
}
}

