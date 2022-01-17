import random
import datetime
file = open("employee.txt","w+")
#pid = 0
#t = ["Truck","Ship","Train","Bus","Flight"]
#rt = ["A1","A2","A3"]
#soi = ["Fisheries", "Dairy","Agriculture", "Poultry", "Processed Foods", "Baked Goods","Spices","Packaging"]
g = ["Male","Female","Transgender","Non-binary","Intersex"]
s = ["20000","25000","30000","45000","70000"]
place = ["Thane","Mumbai","Dombivali","Ghansoli","Trissur","Kalwa","Raipur","Jodhpur","Palakkad","Chennai","Jaipur"]

for j in range(10000) : 
    #processes -
    #pid = pid + 1
    #bs = random.randrange(100,1000)
    #bt = random.randrange(1,5) #in hours
    #qi = random.random()
    #pc = random.randrange(1000,5000) #in rupees

    #file.write("insert into processes(process_id, batch_size,batch_time,quality_index,process_cost) values('" + str(pid)+ "','" +str(bs)+ "','" +str(bt)+ "','" +str(qi)+ "','" + str(pc)+ "'); \n ")

    #region -
    #rid = random.randrange(100,10000)
    #ts = str(random.randrange(0,24)) +":"+ str(random.randrange(0,60))
    #trans = random.choice(t)
    #rdt = random.choice(rt)
    #tc = random.randrange(1000,10000)
    #di = random.random()

    #file.write("insert into region(regional_id,dispatch_time,mode_of_transport,road_type,transport_cost,development_index) values('" +str(rid)+ "','" +str(ts)+ "','" +str(trans)+ "','" +str(rdt)+ "','" +str(tc)+ "','" +str(di)+ "'); \n ")

    #raw material -
    #rid = random.randrange(0,100)
    #ic = random.randrange(1000,5000)
    #qi = random.random()
    #si = random.choice(soi)

    #file.write("insert into raw_material(rm_id,import_cost,quality_index,source_industry) values('" +str(rid)+ "','" +str(ic)+ "','" +str(qi)+ "','" +str(si)+ "'); \n ")

    #employee -
    n = names.get_full_name()
    aid = random.randrange(100,10000)
    gender = random.choice(g)
    outloc = random.choice(place)
    
    start_date = datetime.date(1960,1,1)
    end_date = datetime.date(2012,1,1)
    days_between_dates = (end_date - start_date).days
    random_days = random.randrange(days_between_dates)
    dob = start_date + datetime.timedelta(days = random_days)

    idp = random.randrange(1000,9999)
    sal = random.choice(s)
    
    file.write("insert into employee(name,address_id,gender,outlet_location,dob,id_proof_id,salary) values('" +str(n)+ "','" +str(aid)+ "','" +str(gender)+ "','" +str(outloc)+ "','" +str(dob)+ "','" +str(idp)+ "','" +str(sal)+ "'); \n ")
